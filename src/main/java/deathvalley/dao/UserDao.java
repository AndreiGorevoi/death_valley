/*
@author Andrei Gorevoi
*/
package deathvalley.dao;

import deathvalley.model.User;

public interface UserDao {
    User findUserById(Long id);
}
