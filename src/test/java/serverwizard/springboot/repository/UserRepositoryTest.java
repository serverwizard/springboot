package serverwizard.springboot.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import serverwizard.springboot.domain.user.Role;
import serverwizard.springboot.domain.user.User;

import java.util.Set;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void getRoles() {
        User user = userRepository.getOne(1L);
        Set<Role> userRoles = user.getRoles();
        System.out.println("-----------------");
        for (Role userRole : userRoles) {
            System.out.println(userRole);
        }
    }
}
