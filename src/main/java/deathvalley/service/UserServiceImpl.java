/*
@author Andrei Gorevoi
*/
package deathvalley.service;

import deathvalley.dao.UserDao;
import deathvalley.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserById(Long id) {
        return userDao.findUserById(id);
    }
}
