package tiger.contoller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tiger.model.Account;
import tiger.model.Permission;
import tiger.model.Role;
import tiger.service.AccountService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/account/rest")
@Slf4j
public class AccountRestController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/login")
    public Map<String, Object> login(@RequestParam("username") String userName, @RequestParam("password") String password) {
        Map<String, Object> result = new HashMap<>();
        Account account = accountService.getAccountByName(userName);
        if (account == null || !userName.equals(account.getName()) || !password.equals(account.getPassword())) {
            result.put("msg", "username or password error");
            result.put("status", 400);
        } else {
            result.put("msg", "success");
            result.put("status", 200);
            result.put("accountId", account.getId());
        }
        return result;
    }

    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public void logout(@RequestParam("accountId") String accountId){
        log.info("logout:"+accountId);
    }


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

    @RequestMapping("/getByName")
    public Account getAccount(@RequestParam("name") String name) {
        return accountService.getAccountByName(name);
    }

    @RequestMapping("/search")
    public Map<String, Object> search(@RequestParam("name") String name, @RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize) {
        return accountService.searchAccountByName(name, pageNumber, pageSize);
    }


    @RequestMapping("/getAccounts/{pageNumber}/{pageSize}")
    public Map<String, Object> getAccounts(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize) {
        return accountService.getAccountsByPage(pageNumber, pageSize);
    }

    @RequestMapping("/getPermissions/{id}")
    public List<Permission> getAccountPermissions(@PathVariable("id") long accountId) {
        return accountService.getAllPermissions(accountId);
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
