/*
@author Andrei Gorevoi
*/
package deathvalley.dao;

import deathvalley.model.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAllAccount();
}
