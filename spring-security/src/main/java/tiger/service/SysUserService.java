package tiger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.dao.SysUserMapper;
import tiger.entity.SysUser;

/**
 * @ClassName SysUserService
 * @Description TODO
 * @Author tiger
 * @Date 2019/11/14 21:04
 * @Version 1.0
 **/
@Service
public class SysUserService {

    @Autowired
    private SysUserMapper userMapper;

    public SysUser selectById(Integer id) {
        return userMapper.selectById(id);
    }

    public SysUser selectByName(String name) {
        return userMapper.selectByName(name);
    }
}
