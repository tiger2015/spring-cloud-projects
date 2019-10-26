package tiger.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import tiger.model.User;
import tiger.service.BaseRedisService;
import tiger.service.UserService;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    private static final AtomicLong index = new AtomicLong(0);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    public void save(@RequestParam("name") String name) {
        User user = new User();
        user.setId(String.valueOf(index.getAndIncrement()));
        user.setName(name);
        userService.addUser(user);
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public User get(@PathVariable("id") String id) {
        return userService.getUser(String.format("user:%s", id));
    }
}
