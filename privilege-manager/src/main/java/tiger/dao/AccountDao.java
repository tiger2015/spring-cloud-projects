package tiger.dao;

import org.apache.ibatis.annotations.Mapper;
import tiger.model.Account;
import tiger.model.Role;

import java.util.List;

@Mapper
public interface AccountDao {
    Long insert(Account account);

    Account select(long id);

    List<Account> selectByName(String name);

    boolean delete(long id);

    Long addRole(Role role);
}
