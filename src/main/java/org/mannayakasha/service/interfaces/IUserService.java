package org.mannayakasha.service.interfaces;

import org.mannayakasha.entity.User;
import org.mannayakasha.service.IService;

import java.util.List;

/**
 * Service interface for the {@link org.mannayakasha.entity.User} class.
 *
 * @author Pavel Milovidov
 * @version 1.0 25.10.2017
 */

public interface IUserService extends IService<User> {

    List<User> getAll();

    User getByEmail(String email);
}
