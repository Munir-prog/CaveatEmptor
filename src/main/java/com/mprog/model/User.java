package com.mprog.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class User { // maybe serializable
    // TODO protected
    private String username;

    public BigDecimal calcShippingCosts(Address fromLocation){
        return null;
    }
}
