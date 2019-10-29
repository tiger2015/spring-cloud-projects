package tiger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.dao.AccountDao;
import tiger.model.Account;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Long addAccount(Account account) {
        accountDao.insert(account);
        return account.getId();
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
    public boolean removeAccount(long id) {
        return accountDao.delete(id);
    }
}
