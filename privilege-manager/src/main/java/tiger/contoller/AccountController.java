package tiger.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tiger.model.Account;
import tiger.model.Permission;
import tiger.model.Role;
import tiger.service.AccountService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestParam("user") String name, @RequestParam("password") String password) {

        Account account = new Account();
        account.setName(name);
        account.setPassword(password);

        accountService.addAccount(account);
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id) {
        accountService.removeAccount(id);
    }

    @RequestMapping("/get/{id}")
    public Account getAccount(@PathVariable("id") long id) {
        return accountService.getAccount(id);
    }

    @RequestMapping("/getByName/{name}")
    public List<Account> getAccount(@PathVariable("name") String name) {
        return accountService.getAccountByName(name);
    }

    @RequestMapping("/getAccounts/{pageNumber}/{pageSize}")
    public Map<String, Object> getAccounts(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize) {
        return accountService.getAccountsByPage(pageNumber, pageSize);
    }

    @RequestMapping("/getPermissions/{id}")
    public List<Permission> getAccountPermissions(@PathVariable("id") long accountId) {
        return accountService.getAllPermission(accountId);
    }

    @RequestMapping("/getRoles/{id}")
    public List<Role> getAccountRoles(@PathVariable("id") long accountId) {
        return accountService.getAccountRoles(accountId);
    }


    @RequestMapping("/revoke/{accountId}/{roleId}")
    public void revokeRole(@PathVariable("accountId") long accountId, @PathVariable("roleId") int roleId) {
        accountService.revokeRole(accountId, roleId);
    }

    @RequestMapping("/grant/{accountId}/{roleId}")
    public void grantRole(@PathVariable("accountId") long accountId, @PathVariable("roleId") int roleId) {
        accountService.grantRole(accountId, roleId);
    }

}
