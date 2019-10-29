package tiger.service;

import tiger.model.Account;

import java.util.List;

public interface AccountService {

    Long addAccount(Account account);

    Account getAccount(long id);

    List<Account> getAccountByName(String name);

    boolean removeAccount(long id);
}
