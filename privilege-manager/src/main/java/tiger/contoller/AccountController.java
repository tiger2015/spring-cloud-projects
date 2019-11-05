package tiger.contoller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tiger.model.Account;
import tiger.service.AccountService;

import java.util.Map;

/**
 * @ClassName AccountController
 * @Description TODO
 * @Author zeng.h
 * @Date 2019/11/2 17:40
 * @Version 1.0
 **/
@Controller
@RequestMapping("/account")
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;


    @RequestMapping("/manager")
    public String accountManager(Model model, @RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber) {
        Map<String, Object> accountsByPage = accountService.getAccountsByPage(pageNumber, pageSize);
        model.addAttribute("result", accountsByPage);
        return "account-manager";
    }

    @RequestMapping("/search")
    public String search(Model model, @RequestParam("name") String name, @RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber) {
        Map<String, Object> map = accountService.searchAccountByName(name, pageNumber, pageSize);
        model.addAttribute("result", map);
        model.addAttribute("search", name);
        log.info("search");
        return "account-manager::result";
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") long id) {
        accountService.removeAccount(id);
//        Map<String, Object> map = accountService.searchAccountByName(name, pageNumber, pageSize);
//        model.addAttribute("result", map);
//        model.addAttribute("search", name);
//        log.info("search");
        return;
    }

}
