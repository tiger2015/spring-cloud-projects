package tiger;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *@ClassName SecurityConfiguration
 *@Description TODO
 *@Author zeng.h
 *@Date 2019/10/28 16:30
 *@Version 1.0
 **/
@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthenticationProvider userAuthenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(userAuthenticationProvider);
        auth.userDetailsService(new UserDetailsServiceImpl());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/").permitAll();
        http.formLogin().loginProcessingUrl("/login"); // 登录处理界面
        http.formLogin().defaultSuccessUrl("/index");  // 登录成功后的页面
        http.authorizeRequests().anyRequest().fullyAuthenticated();
        log.info("init security configuration");
    }
}
