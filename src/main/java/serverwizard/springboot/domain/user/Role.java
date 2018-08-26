package serverwizard.springboot.domain.user;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    // 여기에 멤버를 선언해줘도 되지만 멤버를 선언해도 페이징처리도안되기때문에 쓸모가없다
}
