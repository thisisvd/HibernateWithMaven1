package com.maventest.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;

// Make columns in the table in which it is referenced
// so id & name will a column with other column of the parent class
@Embeddable
public class UserWishlist {

    private String id;
    private String name;

    // the below column will be ignored
    @Transient
    private boolean inStock;

    public UserWishlist() {}

    public UserWishlist(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }
}