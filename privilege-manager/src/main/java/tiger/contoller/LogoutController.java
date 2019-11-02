package tiger.contoller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName LogoutController
 * @Description TODO
 * @Author zeng.h
 * @Date 2019/11/2 14:39
 * @Version 1.0
 **/
@Controller
@Slf4j
public class LogoutController {

    @RequestMapping("/logout")
    @ResponseBody()
    public String logout(@RequestParam("accountId") String accountId) {
        log.info("===logout");
        return "login";
    }
}
