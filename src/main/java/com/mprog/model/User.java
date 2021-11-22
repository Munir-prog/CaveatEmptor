package com.mprog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User { // maybe serializable

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    // TODO protected
    private String firstName;
    private String lastName;
    private Set<Item> items = new HashSet<>();
    private Address address;
    private BillingDetails billingDetails;

    public BigDecimal calcShippingCosts(Address fromLocation){
        return null;
    }

//    public void addItem(Item item){
//        if (item == null)
//            throw new NullPointerException("Can't add null item");
//        if (item.getUser() != null)
//            throw new IllegalStateException("Item is already assigned to an User");
//        getItems().add(item);
//        item.setUser(this);
//    }
}
