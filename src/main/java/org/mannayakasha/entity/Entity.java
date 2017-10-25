package org.mannayakasha.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Base class for all entities.
 *
 * @author Pavel
 * @version 1.0 25.10.2017.
 */

@MappedSuperclass
public abstract class Entity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    protected Entity() {}

    protected Entity(Integer id) { this.id = id; }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    @Override
    public String toString() { return "id = " + id; }
}
