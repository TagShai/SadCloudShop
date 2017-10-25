package org.mannayakasha.entity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Contains roles for entity {@link org.mannayakasha.entity.User} class.
 *
 * @author Pavel Milovidov
 * @version 1.0 25.10.2017.
 */


@javax.persistence.Entity
@Table(name = "roles")
public class Role extends Entity {

    @Column(name = "name")
    private String name;

/*    @ManyToMany(mappedBy = "roles")
    private Set<User> users;*/

    public Role() {}

    public Role(String name) {
        this.name = name;
    }

    public Role(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
