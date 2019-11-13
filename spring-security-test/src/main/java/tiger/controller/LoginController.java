package tiger.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author tiger
 * @Date 2019/11/13 22:20
 * @Version 1.0
 **/
@Controller
@Slf4j
public class LoginController {

    @RequestMapping(value = "/login")
    public String login() {
        return "login.html";
    }


    @RequestMapping(value = "/")
    public String home() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("登录用户:{}", name);
        return "home.html";
    }
}
