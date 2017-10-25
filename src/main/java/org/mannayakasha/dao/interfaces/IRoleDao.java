package org.mannayakasha.dao.interfaces;

import org.mannayakasha.dao.IDao;
import org.mannayakasha.entity.Role;

/**
 * Dao interface for {@link org.mannayakasha.entity.Role} class.
 *
 * @author Pavel Milovidov
 * @version 1.0 25.10.2017.
 */

public interface IRoleDao extends IDao<Role> {

    boolean roleExists(String name);
}
