package tiger.service;

import tiger.model.User;

/**
 * @Auther: Administrator
 * @Date: 2019/10/26 18:10
 * @Description:
 */
public interface UserService {

    boolean addUser(User user);

    User getUser(String id);

}
