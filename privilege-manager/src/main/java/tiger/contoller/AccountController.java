package tiger.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tiger.model.Account;
import tiger.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/add")
    public Long add(@RequestParam("user") String name, @RequestParam("password") String password) {

        Account account = new Account();
        account.setName(name);
        account.setPassword(password);

        return accountService.addAccount(account);
    }

    @RequestMapping("/delete/{id}")
    public Boolean delete(@PathVariable("id") long id) {
       return accountService.removeAccount(id);
    }

    @RequestMapping("/get/{id}")
    public Account getAccount(@PathVariable("id") long id){
        return accountService.getAccount(id);
    }

    @RequestMapping("/getByName/{name}")
    public List<Account> getAccount(@PathVariable("name") String name){
        return accountService.getAccountByName(name);
    }

}
