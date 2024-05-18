package springrestAPI.springrestAPI.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .requestMatchers("/user/**").authenticated() // 로그인 한 사람들만
                .requestMatchers("/manager/**").access("hasAnyRole('ROLE_MANAGER','ROLE_ADMIN')") // 로그인을 했지만 매니저나 어드민 권한
                .requestMatchers("/admin/**").access("hasRole('ROLE_ADMIN')") // 로그인으르 했지만 어드민 권한
                .anyRequest().permitAll() // 이외의 요청은 모든 사람에게 권한 허용
                .and()
                .formLogin()
                .loginPage("/loginForm")
                .loginProcessingUrl("/login") // login이라는 주소가 호출이 되면 시큐리티가 낚아채서 대신 로그인을 진행해줌
                .defaultSuccessUrl("/")
        ;

        return http.build();
    }
}
