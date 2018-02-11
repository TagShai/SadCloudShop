package org.mannayakasha.entity;

import javax.persistence.*;

/**
 * Simple JavaBean object, that represents entity product.
 *
 * @author Pavel Milovidov
 * @version 1.0 25.10.2017.
 */

@javax.persistence.Entity
@Table(name = "products")
public class Product extends Entity {

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "description")
    private String description;

    @Column(name = "full_description")
    private String fullDescription;

    @Column(name = "image")
    private String image;

    @Column(name = "novelty")
    private boolean novelty;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "PRODUCT_CATEGORY_FK"))
    private Category category;

    public Product() {}

    public Product(Integer id, String name, Double price, String description, String fullDescription, boolean novelty, Category category, String image) {
        super(id);
        this.name = name;
        this.price = price;
        this.description = description;
        this.fullDescription = fullDescription;
        this.novelty = novelty;
        this.category = category;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isNovelty() {
        return novelty;
    }

    public void setNovelty(boolean novelty) {
        this.novelty = novelty;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "name='" + name +
                ", price=" + price +
                ", description='" + description +
                ", fullDescription='" + fullDescription +
                ", novelty=" + novelty +
                ", category=" + category;
    }
}
