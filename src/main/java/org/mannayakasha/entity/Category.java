package org.mannayakasha.entity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Simple JavaBean object, that represents entity category. Categories for the {@link Product} class.
 *
 * @author Pavel
 * @version 1.0 25.10.2017
 */

@javax.persistence.Entity
@Table(name = "categories")
public class Category extends Entity {

    @Column(name = "name")
    private String name;

    public Category() {}

    public Category(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() +
                "name='" + name;
    }
}
