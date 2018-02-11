package org.mannayakasha.dao.impl;

import org.mannayakasha.dao.interfaces.IProductDao;
import org.mannayakasha.entity.Category;
import org.mannayakasha.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Implementation of {@link org.mannayakasha.dao.interfaces.IProductDao} interface.
 *
 * @author Pavel Milovidov
 * @version 1.0 25.10.2017.
 */

@Repository
@Transactional
public class ProductDaoImpl implements IProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product getById(int id) {
        String hql = "SELECT product FROM Product as product WHERE product.id = :productId";

        return (Product) entityManager.createQuery(hql).setParameter("productId", id).getSingleResult();
    }

    @Override
    public void create(Product product) {
        entityManager.persist(product);
    }

    @Override
    public void update(Product product) {
        Product newProduct = getById(product.getId());
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        newProduct.setDescription(product.getDescription());
        newProduct.setFullDescription(product.getFullDescription());
        newProduct.setImage(product.getImage());
        newProduct.setNovelty(product.isNovelty());
        newProduct.setCategory(product.getCategory());
        entityManager.flush();
    }

    @Override
    public void delete(int id) {
        entityManager.remove(getById(id));
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> getAll() {
        String hql = "SELECT product FROM Product as product";
        return (List<Product>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> getAllWithCategory(String category) {
        String hql = "SELECT product FROM Product as product WHERE product.category.name = ?";
        return (List<Product>) entityManager.createQuery(hql).setParameter(1, category).getResultList();
    }

    @Override
    public Product getByName(String name) {
        String hql = "SELECT product FROM Product as product WHERE lower(product.name) like :name";
        return (Product) entityManager.createQuery(hql).setParameter("name", name).getSingleResult();
    }

    @Override
    public boolean productExists(String name) {
        String hql = "SELECT product FROM Product as product WHERE product.name = ?";
        int count = entityManager.createQuery(hql).setParameter(1, name).getResultList().size();
        return count > 0;
    }
}
