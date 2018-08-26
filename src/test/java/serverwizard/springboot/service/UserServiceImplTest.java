package serverwizard.springboot.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import serverwizard.springboot.domain.user.Role;
import serverwizard.springboot.domain.user.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void 회원_추가() {
        User user = new User();
        user.setName("홍종완");
        user.setEmail("serverwizard@naver.com");
        user.setPassword("1234");
        user = userService.addUser(user);
        System.out.println("---------------------");
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println("---------------------");


        User savedUser = userService.getUserByEmail("serverwizard@naver.com");
        System.out.println("---------------------");
        System.out.println(savedUser.getEmail());
        for (Role role : savedUser.getRoles() ) {
            System.out.println(role.getName());
        }
        System.out.println("---------------------");
    }


}