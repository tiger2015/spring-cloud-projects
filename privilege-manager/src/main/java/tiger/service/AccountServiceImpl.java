package tiger.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.dao.AccountDao;
import tiger.model.Account;
import tiger.model.PageInfo;
import tiger.model.Permission;
import tiger.model.Role;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void addAccount(Account account) {
        accountDao.insert(account);
    }

    @Override
    public Account getAccount(long id) {
        return accountDao.select(id);
    }

    @Override
    public List<Account> getAccountByName(String name) {
        return accountDao.selectByName(name);
    }

    @Override
    public void removeAccount(long id) {
        accountDao.delete(id);
    }

    @Override
    public Map<String, Object> getAccountsByPage(int pageNumber, int pageSize) {
        Page<Account> page = PageHelper.startPage(pageNumber, pageSize);
        Map<String, Object> result = new HashMap<>();
        List<Account> accounts = accountDao.selectAll();
        result.put("result", accounts);
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotal(page.getPages());
        pageInfo.setPageSize(page.getPageSize());
        pageInfo.setCurrent(page.getPageNum());
        result.put("pageInfo", pageInfo);
        return result;
    }

    @Override
    public List<Role> getAccountRoles(long id) {
        return accountDao.getRoles(id);
    }

    @Override
    public void revokeRole(long accountId, int roleId) {
        accountDao.deleteRole(accountId, roleId);
    }

    @Override
    public void grantRole(long accountId, int roleId) {
        accountDao.addRole(accountId, roleId);
    }

    @Override
    public List<Permission> getAllPermission(long id) {
        return accountDao.getAccoutPermissions(id);
    }
}
