package serverwizard.springboot.domain.user;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private LocalDateTime joinDate;

    // join 걸어줄때 중복되는 경우가 혹시 있을수있으니 list보다 set을 사용했다
    // eager로 설정하면 join해서 가지고 온다 (쿼리문 단 한번)
    // eager를 너무 많이 쓰면 join을 만들수가 없어서 에러가 나기도한다, 순환참조 (주의)
    // Member를 통해 MemberRole을 가져오는게 더 효율적이다.
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns =
    @JoinColumn(
            name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles = new HashSet<>();
}

