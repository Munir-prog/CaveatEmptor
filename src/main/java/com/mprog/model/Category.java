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
            throw new NullPointerException("Can't add null Bid");
        if (item.getCategory() != null)
            throw new IllegalStateException("Bid is already assigned to an Item");
        getItems().add(item);
        item.setCategory(this);
    }
}
