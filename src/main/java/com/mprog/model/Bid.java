package com.mprog.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class Bid {

    private BigDecimal amount;
    private LocalDate cratedOn;
    private Item item;
}
