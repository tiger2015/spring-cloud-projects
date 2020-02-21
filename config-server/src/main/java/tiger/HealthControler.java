package tiger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HealthControler
 * @Description TODO
 * @Author zeng.h
 * @Date 2019/9/7 18:52
 * @Version 1.0
 **/
@RestController
public class HealthControler {

    // 自定义健康检查
    @RequestMapping("/health")
    public String headlth() {
        return "OK";
    }

}
