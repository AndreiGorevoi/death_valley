/*
@author Andrei Gorevoi
*/
package deathvalley.dao;

import deathvalley.model.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class AccountDaoImpl implements AccountDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public AccountDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Account> findAllAccount() {
        Session session = sessionFactory.getCurrentSession();
        Query<Account> allAccounts = session.createQuery("from Account ");
        return allAccounts.getResultList();
    }
}
