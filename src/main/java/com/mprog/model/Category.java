package com.mprog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
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
