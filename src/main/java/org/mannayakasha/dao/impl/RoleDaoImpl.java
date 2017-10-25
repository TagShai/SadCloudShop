package org.mannayakasha.dao.impl;

import org.mannayakasha.dao.interfaces.IRoleDao;
import org.mannayakasha.entity.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Implementation of {@link org.mannayakasha.dao.interfaces.IRoleDao} interface.
 *
 * @author Pavel Milovidov
 * @version 1.0 25.10.2017.
 */

@Transactional
@Repository
public class RoleDaoImpl implements IRoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getById(int id) {
        String hql = "SELECT role FROM Role as role WHERE role.id = :roleId";

        Role role = (Role) entityManager.createQuery(hql).setParameter("roleId", id).getSingleResult();

        return role;
    }

    @Override
    public void create(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void update(Role role) {
        Role newRole = getById(role.getId());
        newRole.setName(role.getName());
        entityManager.flush();
    }

    @Override
    public void delete(int id) {
        entityManager.remove(getById(id));
    }

    @Override
    public boolean roleExists(String name) {
        String hql = "FROM Role as role WHERE role.name = ?";
        int count = entityManager.createQuery(hql).setParameter(1, name).getResultList().size();
        return count > 0;
    }
}
