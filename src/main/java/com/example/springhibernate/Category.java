package com.example.springhibernate;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import java.util.HashSet;
import java.util.Set;
/*@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)*/
public class Category {
    private long id;
    private String name;
    private Category parentCategory;
    private Set<Category> childCategories=new HashSet<>();

    private Set<Item> items=new HashSet<>();

    public Category() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
        //java.sql.Date
        //java.util.Date
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Set<Category> getChildCategories() {
        return childCategories;
    }

    public void setChildCategories(Set<Category> childCategories) {
        this.childCategories = childCategories;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public void addChildCategory(Category childCategory){
        if(childCategory==null) throw new IllegalArgumentException("Null child category!");
        if(childCategory.getParentCategory()!=null)
            childCategory.getParentCategory().getChildCategories().remove(childCategory);
        childCategory.setParentCategory(this);
        childCategories.add(childCategory);
    }

   /* @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentCategory=" + parentCategory +
                ", childCategories=" + childCategories +
                ", items=" + items +
                '}';
    }*/
}
