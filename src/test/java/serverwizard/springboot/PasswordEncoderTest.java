package serverwizard.springboot;

import org.junit.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderTest {
    @Test
    public void testEncoding() throws Exception {
        PasswordEncoder passwordEncoder =
                // 암호화 방식에따라 구현체는 다양할 수 있다 (PasswordEncoder인테페이스기 때문에)
                PasswordEncoderFactories.createDelegatingPasswordEncoder(); // Delegating(위임), 패스워드 인코딩을 위임하는 클래스
        String encodeStr = passwordEncoder.encode("1234");
        System.out.println(encodeStr);
    }
}
