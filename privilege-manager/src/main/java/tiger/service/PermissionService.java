package tiger.service;

import tiger.model.Permission;

import java.util.List;

public interface PermissionService {


    /**
     * @param permission
     * @return int
     * @autho tiger
     * @description TODO
     * @date 2019/10/29 23:10
     **/
    int addPermission(Permission permission);

    /**
     * @autho tiger
     * @description 获取权限
     * @date 2019/10/29 23:13
     * @param id
     * @return tiger.model.Permission
     **/
    Permission getPermission(int id);

    /**
     * @autho tiger
     * @description TODO
     * @date 2019/10/29 23:13
     * @param name
     * @return
     **/
    List<Permission> getPermissionByName(String name);

    /**
     * @autho tiger
     * @description TODO
     * @date 2019/10/29 23:13
     * @param id
     * @return boolean
     **/
    boolean removePermission(int id);

}
