package com.mprog.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Item {

    private String name;
    private String description;
    private LocalDate createdOn;
    private boolean verified;
    private AuctionType auctionType;
    private BigDecimal initialPrice;
    private LocalDate auctionStart;
    private LocalDate auctionEnd;
}
