package org.mannayakasha.service.impl;

import org.mannayakasha.dao.interfaces.IProductDao;
import org.mannayakasha.entity.Category;
import org.mannayakasha.entity.Product;
import org.mannayakasha.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of {@link org.mannayakasha.service.interfaces.IProductService} interface.
 *
 * @author Pavel Milovidov
 * @version 1.0 25.10.2017.
 */

@Service("productService")
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public Product getById(int id) {
        return productDao.getById(id);
    }

    @Override
    public boolean create(Product product) {
        if (productDao.productExists(product.getName())) {
            return false;
        } else {
            productDao.create(product);
            return true;
        }
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public void delete(int id) {
        productDao.delete(id);
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public List<Product> getAllWithCategory(String category) { return productDao.getAllWithCategory(category); }

    @Override
    public Product getByName(String name) {
        return productDao.getByName(name);
    }
}
