package org.mannayakasha.dao;

import org.mannayakasha.entity.Entity;

/**
 * Base dao interface, that includes CRUD operations.
 *
 * @author Pavel Milovidov
 * @version 1.0 25.10.2017.
 */

public interface IDao<T extends Entity> {

    /**
     * Find some entity by id
     * @param id id of the entity
     * @return found entity
     */
    T getById(int id);

    /**
     * Create new instance of some entity
     * @param entity Entity to create
     */
    void create(T entity);

    /**
     * Update instance of some entity
     * @param entity Entity to update
     */
    void update(T entity);

    /**
     * Delete instance of some entity
     * @param id id of entity, that need to delete
     */
    void delete(int id);
}
