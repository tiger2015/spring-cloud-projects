package tiger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.dao.SysRoleMapper;
import tiger.entity.SysRole;

/**
 * @ClassName SysRoleService
 * @Description TODO
 * @Author tiger
 * @Date 2019/11/14 21:06
 * @Version 1.0
 **/
@Service
public class SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    public SysRole selectById(Integer id) {
        return sysRoleMapper.selectById(id);
    }
}
