package tiger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
@Slf4j
public class GreetingController {
    @ResponseBody
    @RequestMapping("hello/{name}")
    public String hello(@PathVariable("name") String name) {
       log.info("call hello service");
        return "hello," + name;
    }
}
