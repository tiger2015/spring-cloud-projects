package tiger.service;

import tiger.model.Permission;
import tiger.model.Role;

import java.util.List;

/**
 * @ClassName RoleService
 * @Description TODO
 * @Author tiger
 * @Date 2019/10/31 20:33
 * @Version 1.0
 **/
public interface RoleService {

    void addRole(Role role);

    void deleteRole(int id);

    Role getRoleByName(String name);
    
    List<Role> searchRoleByName(String name);

    Role getRole(int id);

    void addPermission(int roleId, int permissionId);

    void removePermission(int roleId, int permissionId);

    List<Permission> getAllPermissions(int id);
}
