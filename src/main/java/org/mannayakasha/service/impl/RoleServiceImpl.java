package org.mannayakasha.service.impl;

import org.mannayakasha.dao.interfaces.IRoleDao;
import org.mannayakasha.entity.Role;
import org.mannayakasha.service.interfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link org.mannayakasha.service.interfaces.IRoleService} interface.
 *
 * @author Pavel Milovidov
 * @version 1.0 25.09.2017.
 */

@Service("roleService")
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public Role getById(int id) {
        Role role = roleDao.getById(id);
        return role;
    }

    @Override
    public boolean create(Role role) {
        if (roleDao.roleExists(role.getName())) {
            return false;
        } else {
            roleDao.create(role);
            return true;
        }
    }

    @Override
    public void update(Role role) {
        roleDao.update(role);
    }

    @Override
    public void delete(int id) {
        roleDao.delete(id);
    }
}
