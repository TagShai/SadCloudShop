package org.mannayakasha.dao.interfaces;

import org.mannayakasha.dao.IDao;
import org.mannayakasha.entity.User;

import java.util.List;

/**
 * Dao interface for the {@link org.mannayakasha.entity.User} class.
 *
 * @author Pavel Milovidov
 * @version 1.0 25.10.2017
 */

public interface IUserDao extends IDao<User> {

    List<User> getAll();

    User getByEmail(String email);

    boolean userExists(String email);
}
