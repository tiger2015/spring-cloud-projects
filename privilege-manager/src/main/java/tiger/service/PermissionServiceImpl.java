package tiger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.dao.PermissionDao;
import tiger.model.Permission;

import java.util.List;

/**
 * @ClassName PermissionServiceImpl
 * @Description TODO
 * @Author tiger
 * @Date 2019/10/29 23:12
 * @Version 1.0
 **/
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public int addPermission(Permission permission) {
        permissionDao.insert(permission);
        return permission.getId();
    }

    @Override
    public Permission getPermission(int id) {
        return permissionDao.select(id);
    }

    @Override
    public List<Permission> getPermissionByName(String name) {
        return permissionDao.selectByName(name);
    }

    @Override
    public boolean removePermission(int id) {
        return permissionDao.delete(id);
    }
}
