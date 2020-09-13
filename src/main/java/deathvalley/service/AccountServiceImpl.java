/*
@author Andrei Gorevoi
*/
package deathvalley.service;

import deathvalley.dao.AccountDao;
import deathvalley.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountDao accountDao;

    @Autowired
    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountDao.findAllAccount();
    }
}
