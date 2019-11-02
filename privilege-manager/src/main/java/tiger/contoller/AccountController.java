package tiger.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName AccountController
 * @Description TODO
 * @Author zeng.h
 * @Date 2019/11/2 17:40
 * @Version 1.0
 **/
@Controller
@RequestMapping("/account")
public class AccountController {

    @RequestMapping("/manager")
    public ModelAndView accountManager(){

       return null;
    }

}
