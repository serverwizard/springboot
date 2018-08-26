package serverwizard.springboot.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserLoginInfo extends User {
    private Long id;
    private String name;

    public UserLoginInfo(String email, String password, Collection<? extends GrantedAuthority> authorities){
        super(email, password, authorities);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}