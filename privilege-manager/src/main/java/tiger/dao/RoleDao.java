package tiger.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tiger.model.Permission;
import tiger.model.Role;

import java.util.List;

@Mapper
public interface RoleDao {

    void insert(Role role);

    Role select(int id);

    Role selectByName(String name);

    List<Role> selectLikeName(String name);

    void delete(int id);

    /**
     * 添加权限
     * @autho tiger
     * @description TODO
     * @date 2019/10/30 23:12
     * @param roleId
     * @param permissionId
     * @return java.lang.Long
     **/
    void insertPermission(@Param("roleId") int roleId, @Param("permissionId") int permissionId);

    /**
     * 删除权限
     * @autho tiger
     * @description TODO
     * @date 2019/10/30 23:13
     * @param roleId
     * @param permissionId
     * @return java.lang.Long
     **/
    void deletePermission(@Param("roleId") int roleId, @Param("permissionId") int permissionId);

    /**
     * 获取所有的权限
     * @autho tiger
     * @description TODO
     * @date 2019/10/30 23:13
     * @param id
     * @return java.util.List<tiger.model.Permission>
     **/
    List<Permission> selectAllPermissions(int id);
}
