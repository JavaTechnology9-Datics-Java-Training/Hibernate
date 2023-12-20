package com.example.springhibernate;

import java.util.HashSet;
import java.util.Set;

public class Item {
    private long id;
    private String name;
    private String description;
    private Set<Category> categories=new HashSet<>();

    private Set<Bid> bids=new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Bid> getBids() {
        return bids;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }

    public void addCategory(Category category){
        if(category==null) throw new IllegalArgumentException("Null category");
        category.getItems().add(this);
        categories.add(category);
    }
}
