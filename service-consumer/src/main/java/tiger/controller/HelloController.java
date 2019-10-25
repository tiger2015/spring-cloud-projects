package tiger.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tiger.service.RedisService;

@RestController
@Slf4j
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${name}")
    private String name;

    @Autowired
    private RedisService<String, String, String, String> redisService;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        log.info("hello request");
        return restTemplate.getForObject("http://SERVICE-PROVIDER/service/hello/" + name, String.class);
    }

    @RequestMapping("/test")
    public String test() {
        redisService.save("test", "test");
        return name;
    }
}
