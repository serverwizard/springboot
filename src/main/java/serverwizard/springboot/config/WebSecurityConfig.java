package serverwizard.springboot.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
// 스프링 시큐리티와 관련된 설정파일
//@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    // 스프링 시큐리티에서 가장 기본적인 설정
    // 필요하다면 찾아서 설정해주면된다
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                                                 // 디폴트 정적자원 위치
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                .requestMatchers(new AntPathRequestMatcher("/**.html"))
                .requestMatchers(new AntPathRequestMatcher("/static/**"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/").hasRole("USER")
                    .antMatchers("/boards/writeform").hasRole("USER")
                    .antMatchers(HttpMethod.POST,"/boards").hasRole("USER")
                    .antMatchers("/boards/**").permitAll()
                    .antMatchers("/users/joinform").permitAll()
                    .antMatchers(HttpMethod.POST,"/members").permitAll()
                    .antMatchers("/users/welcome").permitAll()
                    .antMatchers("/users/login").permitAll()
                    .antMatchers("/users/**").hasRole("USER")
                    .antMatchers("/api/**").hasRole("USER")
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/h2-console/**").permitAll()
                    .anyRequest().fullyAuthenticated()
                .and().csrf() // h2콘솔에서 필요 (실무에서는 csrf공격 방지를 위해 사용해야함)
                    .ignoringAntMatchers("/**")
                .and()  // h2콘솔에서 필요 (h2 콘솔은 내부적으로 frame을 사용함)
                    .headers().frameOptions().disable()
                // 로그인을 담당하는 스프링 시큐리티 필터
                .and().formLogin() // form방식의 로그인
                     .loginPage("/users/login")
                         .usernameParameter("email")
                         .passwordParameter("password")
                // loginProcessingUrl : 설정된 url을 컨트롤러에다가 개발자가 직접 만드는게 아니다
                // 단지 로그인 페이지 form action 부분에 입력된 주소를 지정해준다, 해당 url이 들어올경우 로그인처리하는 스프링시큐리티 필터가 처리해주는 형태다
                     .loginProcessingUrl("/users/login") // post방식으로 전달.
                     .successForwardUrl("/users/login")
                .and()
                //로그아웃을 담당하는 스프링 시큐리티 필터
                    .logout()
                // logout uri가 들어올 경우 로그아웃을 담당하는 스프링 시큐리티 필터가 동작함
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/boards")
                    .permitAll();

    }
}