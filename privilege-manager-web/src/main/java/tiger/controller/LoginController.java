package tiger.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author zeng.h
 * @Date 2019/10/28 15:28
 * @Version 1.0
 **/
//@Controller
@Slf4j
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam Map<String, Object> params) {
        log.info("params:"+params.toString());
        return "index";
    }
}
