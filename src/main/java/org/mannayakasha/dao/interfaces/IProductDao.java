package org.mannayakasha.dao.interfaces;

import org.mannayakasha.dao.IDao;
import org.mannayakasha.entity.Category;
import org.mannayakasha.entity.Product;

import java.util.List;

/**
 * Dao interface for the {@link org.mannayakasha.entity.Product} class.
 *
 * @author Pavel Milovidov
 * Created on 25.10.2017.
 */

public interface IProductDao extends IDao<Product> {

    List<Product> getAll();

    List<Product> getAllWithCategory(String category);

    Product getByName(String name);

    boolean productExists(String name);
}
