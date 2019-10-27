package tiger.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.config.ApplicationConfig;
import tiger.model.User;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author zeng.h
 * @Date 2019/10/26 18:21
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BaseRedisService baseRedisService;

    @Override
    public boolean addUser(User user) {
        long id = baseRedisService.incrAndGet(ApplicationConfig.USER_ID);
        user.setId(String.valueOf(id));
        baseRedisService.save(String.format("user:%s", user.getId()), user);
        return false;
    }

    @Override
    public User getUser(String id) {
        return (User) baseRedisService.get(id);
    }
}
