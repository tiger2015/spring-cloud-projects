package tiger.service;

import tiger.model.Permission;
import tiger.model.Url;

import java.util.List;
import java.util.Map;

public interface PermissionService {


    /**
     * @param permission
     * @return int
     * @autho tiger
     * @description TODO
     * @date 2019/10/29 23:10
     **/
    void addPermission(Permission permission);

    /**
     * @autho tiger
     * @description 获取权限
     * @date 2019/10/29 23:13
     * @param id
     * @return tiger.model.Permission
     **/
    Permission getPermission(int id);

    Permission getPermissionByName(String name);

    /**
     * @autho tiger
     * @description TODO
     * @date 2019/10/29 23:13
     * @param name
     * @return
     **/
    Map<String, Object> searchPermissionByName(String name, int pageNumber, int pageSize);

    Map<String,Object> getPermissionByPage(int startPage, int pageSize);

    /**
     * @autho tiger
     * @description TODO
     * @date 2019/10/29 23:13
     * @param id
     * @return boolean
     **/
    void removePermission(int id);

    /**
     *
     * @param permissionId
     * @param urlId
     * @return
     */
    void addUrl(int permissionId, int urlId);

    /**
     * @autho tiger
     * @description TODO
     * @date 2019/10/31 20:23
     * @param permissioinId
     * @param urlId
     * @return boolean
     **/
    void removeUrl(int permissioinId, int urlId);

    /**
     * @autho tiger
     * @description TODO
     * @date 2019/10/31 20:23
     * @param id
     * @return java.util.List<tiger.model.Url>
     **/
    List<Url> getAllUrls(int id);
}
