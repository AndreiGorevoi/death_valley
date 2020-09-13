/*
@author Andrei Gorevoi
*/
package deathvalley.dao;

import deathvalley.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User findUserById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("from User where id= : id");
        query.setParameter("id",id);
        return query.getSingleResult();
    }
}
