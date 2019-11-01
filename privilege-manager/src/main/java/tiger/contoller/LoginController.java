package tiger.contoller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tiger.model.Account;
import tiger.service.AccountService;

import java.util.Map;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author tiger
 * @Date 2019/11/1 21:30
 * @Version 1.0
 **/
@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView login(@RequestParam Map<String, Object> param) {
        String username = (String) param.get("username");
        Account account = accountService.getAccountByName(username);
        String password = (String) param.get("password");
        ModelAndView modelAndView = new ModelAndView();
        log.info("==========login");
        if(account == null || !username.equals(account.getName())|| !password.equals(account.getPassword())){
            modelAndView.setViewName("login");
            modelAndView.addObject("error","username or password error");
        }else {
            modelAndView.setViewName("index");
            modelAndView.addObject("account", account.getName());
            modelAndView.addObject("accountId",account.getId());
        }
        return modelAndView;
    }
}
