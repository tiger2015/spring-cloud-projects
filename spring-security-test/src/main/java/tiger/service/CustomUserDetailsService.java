package tiger.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @ClassName CustomUserDetailsService
 * @Description TODO
 * @Author tiger
 * @Date 2019/11/13 22:22
 * @Version 1.0
 **/
@Service("userDetailsService")
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("user authentic, user{}",username);
        if(!"admin".equals(username)){
            throw new UsernameNotFoundException("username not exists");
        }
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        return new User(username,"admin", authorities);
    }
}
