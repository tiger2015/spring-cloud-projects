package tiger.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tiger.model.Permission;
import tiger.model.Url;
import tiger.service.PermissionService;

import java.util.List;
import java.util.Map;

/**
 * @ClassName PermissionController
 * @Description TODO
 * @Author tiger
 * @Date 2019/10/31 20:56
 * @Version 1.0
 **/
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addPermission(@RequestParam("name") String name, @RequestParam("desc") String description) {
        Permission permission = new Permission();
        permission.setName(name);
        permission.setDescription(description);
        permissionService.addPermission(permission);
    }

    @RequestMapping(value = "/remove/{id}")
    public void removePermission(@PathVariable("id") int id) {
        permissionService.removePermission(id);
    }

    @RequestMapping(value = "/get/{id}")
    public Permission get(@PathVariable("id") int id) {
        return permissionService.getPermission(id);
    }

    @RequestMapping(value = "/getByName/{name}")
    public List<Permission> getByName(@PathVariable("name") String name) {
        return permissionService.getPermissionByName(name);
    }

    @RequestMapping(value = "/getPermissions/{pageNumber}/{pageSize}")
    public Map<String,Object> getPermissions(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return permissionService.getPermissionByPage(pageNumber,pageSize);
    }

    @RequestMapping(value = "/addUrl/{permissionId}/{urlId}")
    public void addUrl(@PathVariable("permissionId") int permissionId, @PathVariable("urlId") int urlId) {
        permissionService.addUrl(permissionId, urlId);
    }

    @RequestMapping(value = "/removeUrl/{permissionId}/{urlId}")
    public void removeUrl(@PathVariable("permissionId") int permissionId, @PathVariable("urlId") int urlId) {
        permissionService.removeUrl(permissionId, urlId);
    }

    @RequestMapping(value = "/getUrls/{id}")
    public List<Url> getAllUrl(@PathVariable("id") int id) {
        return permissionService.getAllUrls(id);
    }
}
