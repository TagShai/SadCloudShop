package org.mannayakasha.dao.impl;

import org.mannayakasha.dao.interfaces.IUserDao;
import org.mannayakasha.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Implementation of the {@link org.mannayakasha.dao.interfaces.IUserDao} interface.
 *
 * @author Pavel Milovidov
 * @version 1.0 25.10.2017
 */

@Transactional
@Repository
public class UserDaoImpl implements IUserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        String hql = "SELECT user FROM User as user";
        return (List<User>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public User getByEmail(String email) {
        String hql = "SELECT user FROM User as user WHERE lower(user.email) like :email";

        User user = (User) entityManager.createQuery(hql).setParameter("email", email).getSingleResult();

        return user;
    }

    @Override
    public boolean userExists(String email) {
        String hql = "FROM User as u WHERE u.email = ?";
        int count = entityManager.createQuery(hql).setParameter(1, email).getResultList().size();
        return count > 0;
    }

    @Override
    public User getById(int id) {
        String hql = "SELECT user FROM User as user WHERE user.id = :userId";

        User user = (User) entityManager.createQuery(hql).setParameter("userId", id).getSingleResult();

        return user;
    }

    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        User newUser = getById(user.getId());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setActive(user.isActive());
        entityManager.flush();
    }

    @Override
    public void delete(int id) {
        entityManager.remove(getById(id));
    }
}
