package tiger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import tiger.service.CustomUserDetailsService;

/**
 * @ClassName WebSecurityConfig
 * @Description TODO
 * @Author tiger
 * @Date 2019/11/13 22:27
 * @Version 1.0
 **/
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 设置用户密码加密
       auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {
           @Override
           public String encode(CharSequence rawPassword) {
               return rawPassword.toString();
           }

           @Override
           public boolean matches(CharSequence rawPassword, String encodedPassword) {
               return rawPassword.equals(encodedPassword);
           }
       });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll()
                .and()
                .logout().permitAll()
                .and()
                .rememberMe(); // 自动登录
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/css/*","/js/**");
    }
}
