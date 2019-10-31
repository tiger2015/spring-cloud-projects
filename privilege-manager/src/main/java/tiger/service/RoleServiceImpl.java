package tiger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.dao.RoleDao;
import tiger.model.Permission;
import tiger.model.Role;

import java.util.List;

/**
 * @ClassName RoleServiceImpl
 * @Description TODO
 * @Author tiger
 * @Date 2019/10/31 20:35
 * @Version 1.0
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public void addRole(Role role) {
        roleDao.insert(role);
    }

    @Override
    public void deleteRole(int id) {
        roleDao.delete(id);
    }

    @Override
    public List<Role> getRoleByName(String name) {
        return roleDao.selectByName(name);
    }

    @Override
    public Role getRole(int id) {
        return roleDao.select(id);
    }

    @Override
    public void addPermission(int roleId, int permissionId) {
      roleDao.addPermission(roleId, permissionId);
    }

    @Override
    public void removePermission(int roleId, int permissionId) {
         roleDao.removePermission(roleId, permissionId);
    }

    @Override
    public List<Permission> getAllPermissions(int id) {
        return roleDao.getAllPermission(id);
    }
}
