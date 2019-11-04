package tiger.service;

import tiger.model.Account;
import tiger.model.Permission;
import tiger.model.Role;

import java.util.List;
import java.util.Map;

public interface AccountService {

    void addAccount(Account account);

    Account getAccount(long id);

    Account getAccountByName(String name);

    Map<String, Object> searchAccountByName(String name, int pageNumber, int pageSize);

    void removeAccount(long id);

    /**
     * 获取所有用户信息 分页查询
     *
     * @param pageNumber
     * @param pageSize
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @autho tiger
     * @description TODO
     * @date 2019/10/31 22:27
     **/
    Map<String, Object> getAccountsByPage(int pageNumber, int pageSize);

    /**
     * 获取用户的所有角色
     *
     * @param id
     * @return java.util.List<tiger.model.Role>
     * @autho tiger
     * @description TODO
     * @date 2019/10/31 20:06
     **/
    List<Role> getAccountRoles(long id);

    /**
     * 回收用户的角色
     *
     * @param accountId
     * @param roleId
     * @return boolean
     * @autho tiger
     * @description TODO
     * @date 2019/10/31 20:07
     **/
    void revokeRole(long accountId, int roleId);

    /**
     * 授权
     *
     * @param accountId
     * @param roleId
     * @return Long
     * @autho tiger
     * @description TODO
     * @date 2019/10/31 20:08
     **/
    void grantRole(long accountId, int roleId);

    /**
     * 获取用户的所有权限
     *
     * @param id
     * @return java.util.List<tiger.model.Permission>
     * @autho tiger
     * @description TODO
     * @date 2019/10/31 20:18
     **/
    List<Permission> getAllPermissions(long id);

}
