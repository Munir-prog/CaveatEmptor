package com.mprog.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Category {

    private Set<Item> items = new HashSet<>();
    private String name;

    public void addItem(Item item){
        if (item == null)
            throw new NullPointerException("Can't add null item");
        if (item.getCategory() != null)
            throw new IllegalStateException("Item is already assigned to an Category");
        getItems().add(item);
        item.setCategory(this);
    }
}
