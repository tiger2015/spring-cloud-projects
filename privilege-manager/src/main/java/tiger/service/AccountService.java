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

    List<Account> searchAccountByName(String name);

    void removeAccount(long id);

    /**
     * 获取所有用户信息 分页查询
     * @autho tiger
     * @description TODO
     * @date 2019/10/31 22:27
     * @param pageNumber
     * @param pageSize
     * @return java.util.Map<java.lang.String, java.lang.Object>
     **/
    Map<String,Object>  getAccountsByPage(int pageNumber, int pageSize);

    /**
     * 获取用户的所有角色
     * @autho tiger
     * @description TODO
     * @date 2019/10/31 20:06
     * @param id
     * @return java.util.List<tiger.model.Role>
     **/
    List<Role> getAccountRoles(long id);

    /**
     * 回收用户的角色
     * @autho tiger
     * @description TODO
     * @date 2019/10/31 20:07
     * @param accountId
     * @param roleId
     * @return boolean
     **/
    void revokeRole(long accountId, int roleId);

    /**
     * 授权
     * @autho tiger
     * @description TODO
     * @date 2019/10/31 20:08
     * @param accountId
     * @param roleId
     * @return Long
     **/
    void grantRole(long accountId, int roleId);

    /**
     * 获取用户的所有权限
     * @autho tiger
     * @description TODO
     * @date 2019/10/31 20:18
     * @param id
     * @return java.util.List<tiger.model.Permission>
     **/
    List<Permission> getAllPermissions(long id);

}
