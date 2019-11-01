package tiger.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tiger.model.Permission;
import tiger.model.Role;
import tiger.service.RoleService;

import java.util.List;

/**
 * @ClassName RoleController
 * @Description TODO
 * @Author tiger
 * @Date 2019/10/31 20:48
 * @Version 1.0
 **/
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addRole(@RequestParam("name") String roleName, @RequestParam("desc") String description) {
        Role role = new Role();
        role.setName(roleName);
        role.setDescription(description);
        roleService.addRole(role);
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        roleService.deleteRole(id);
    }

    @RequestMapping("/get/{id}")
    public Role get(@PathVariable("id") int id) {
        return roleService.getRole(id);
    }

    @RequestMapping("/getByName")
    public Role getByName(@RequestParam("name") String name) {
        return roleService.getRoleByName(name);
    }

    @RequestMapping("/search")
    public List<Role> search(@RequestParam("name") String name) {
        return roleService.searchRoleByName(name);
    }

    @RequestMapping("/addPermission/{roleId}/{permissionId}")
    public void addPermission(@PathVariable("roleId") int roleId, @PathVariable("permissionId") int permissionId) {
        roleService.addPermission(roleId, permissionId);
    }

    @RequestMapping("/removePermission/{roleId}/{permissionId}")
    public void removePermission(@PathVariable("roleId") int roleId, @PathVariable("permissionId") int permissionId) {
        roleService.removePermission(roleId, permissionId);
    }

    @RequestMapping("/getPermissions/{id}")
    public List<Permission> getAllPermission(@PathVariable("id") int id) {
        return roleService.getAllPermissions(id);
    }

}
