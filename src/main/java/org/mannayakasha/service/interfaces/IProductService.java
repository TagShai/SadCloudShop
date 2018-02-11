package org.mannayakasha.service.interfaces;

import org.mannayakasha.entity.Category;
import org.mannayakasha.entity.Product;
import org.mannayakasha.service.IService;

import java.util.List;

/**
 * Service interface for the {@link org.mannayakasha.entity.Product} class.
 *
 * @author Pavel Milovidov
 * @version 1.0 25.10.2017.
 */

public interface IProductService extends IService<Product> {

    List<Product> getAll();

    List<Product> getAllWithCategory(String category);

    Product getByName(String name);
}
