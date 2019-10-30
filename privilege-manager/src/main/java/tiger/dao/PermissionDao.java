package tiger.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tiger.model.Permission;
import tiger.model.Url;

import java.util.List;

@Mapper
public interface PermissionDao {
    Long insert(Permission permission);

    Permission select(int id);

    List<Permission> selectByName(String name);

    boolean delete(int id);

    /**
     * 给权限加入URL
     * @autho tiger
     * @description TODO
     * @date 2019/10/30 23:00
     * @param permissionId
     * @param urlId
     * @return java.lang.Long
     **/
    Long addUrl(@Param("permissionId") int permissionId, @Param("urlId") int urlId);

    /**
     * 给权限移除URL
     * @autho tiger
     * @description TODO
     * @date 2019/10/30 23:01
     * @param permissionId
     * @param urlId
     * @return boolean
     **/
    boolean removeUrl(@Param("permissionId") int permissionId, @Param("urlId") int urlId);

    /**
     * 获取权限的URL
     * @autho tiger
     * @description TODO
     * @date 2019/10/30 23:01
     * @param id
     * @return java.util.List<tiger.model.Url>
     **/
    List<Url> getAllUrl(int id);
}
