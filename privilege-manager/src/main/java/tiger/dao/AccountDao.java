package tiger.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tiger.model.Account;
import tiger.model.Permission;
import tiger.model.Role;

import java.util.List;

@Mapper
public interface AccountDao {
    void insert(Account account);

    Account select(long id);

    Account selectByName(String name);

    List<Account> selectLikeName(String name);

    List<Account> selectAll();

    void delete(long id);

    /**
     * @autho tiger
     * @description 添加角色
     * @date 2019/10/30 22:38
     * @param accountId
     * @param roleId
     * @return java.lang.Long
     **/
    void insertRole(@Param("userId") long accountId, @Param("roleId") int roleId);

    /**
     * 删除角色
     * @autho tiger
     * @description TODO
     * @date 2019/10/30 22:56
     * @param accountId
     * @param roleId
     * @return
     **/
    void deleteRole(@Param("userId") long accountId, @Param("roleId") int roleId);

    /**
     * 查询用户角色
     * @autho tiger
     * @description TODO
     * @date 2019/10/30 22:38
     * @param id
     * @return java.util.List<tiger.model.Role>
     **/
    List<Role> selectRoles(long id);

    /**
     * 查找用户权限
     * @autho tiger
     * @description TODO
     * @date 2019/10/31 20:09
     * @param id
     * @return java.util.List<tiger.model.Permission>
     **/
    List<Permission> selectPermissions(long id);
}
