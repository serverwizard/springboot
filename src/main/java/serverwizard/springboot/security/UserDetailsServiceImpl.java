package serverwizard.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import serverwizard.springboot.domain.user.User;
import serverwizard.springboot.repository.RoleRepository;
import serverwizard.springboot.service.UserService;

import java.util.ArrayList;
import java.util.List;

// UserDetailsService : 스프링 시큐리팅서 제공하는 DB로부터 사용자 정보를 읽어오는 인터페이스
// UserDetailsService에서 사용자 정보를 읽어서 UserDetails를 반환
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleRepository;

    // UserDetails : 스프링 시큐리티에서 제공하는 사용자 인터페이스 (ID, Password, Role을 가짐)
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // DB로부터 사용자 정보를 읽어옴 (사용자로부터 날아온 비밀번호와 비교할 password를 얻기 위해)
        User savedUser = userService.getUserByEmail(email);

        // GrantedAuthority : 권한을 뜻하는 인터페이스, 해당 사용자가 가지고있는 권한을 가져옴 (권한 비교를 위해)
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(
                roleRepository.findByName("ROLE_USER")
                        .orElseThrow(() -> new IllegalArgumentException("USER 권한을 가지고 있지 않습니다.")).
                        getName()));

        UserLoginInfo userLoginInfo = new UserLoginInfo(savedUser.getEmail(), savedUser.getPassword(), roles);
        userLoginInfo.setId(savedUser.getId());
        userLoginInfo.setName(savedUser.getName());
        return userLoginInfo;
    }
}
