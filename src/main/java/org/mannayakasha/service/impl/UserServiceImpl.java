package org.mannayakasha.service.impl;

import org.mannayakasha.dao.interfaces.IUserDao;
import org.mannayakasha.entity.User;
import org.mannayakasha.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the {@link org.mannayakasha.service.interfaces.IUserService} interface.
 *
 * @author Pavel Milovidov
 * @version 1.0 25.10.2017
 */

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User getByEmail(String email) {
        return userDao.getByEmail(email);
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public boolean create(User user) {
        if (userDao.userExists(user.getEmail())) {
            return false;
        } else {
            userDao.create(user);
            return true;
        }
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}