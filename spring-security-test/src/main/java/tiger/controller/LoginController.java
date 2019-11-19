package tiger.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @RequestMapping(value = "/login/invalid")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public String invalid(){
        return "session timeout";
    }


    @RequestMapping(value = "/")
    public String home() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("登录用户:{}", name);
        return "home.html";
    }

    @RequestMapping("/login/error")
    public void loginError(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        AuthenticationException exception =
                (AuthenticationException) request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        try {
            response.getWriter().write(exception.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/admin")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String printAdmin(){
        return "ADMIN 角色";
    }

    @RequestMapping("/user")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER')")
    public String printTest(){
        return "USER 角色";
    }


    @RequestMapping("/admin/c")
    @ResponseBody
    @PreAuthorize(value = "hasPermission('/admin','c')")
    public String admin(){
        return "has permission for /admin c";
    }


}
