package com.mprog.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Item {

    private Category category;
    private String name;
    private String description;
    private LocalDate createdOn;
    private boolean verified;
    private AuctionType auctionType;
    private BigDecimal initialPrice;
    private LocalDate auctionStart;
    private LocalDate auctionEnd;
    private Set<Bid> bids = new HashSet<>();

    public void addBid(Bid bid){
        if (bid == null)
            throw new NullPointerException("Can't add null Bid");
        if (bid.getItem() != null)
            throw new IllegalStateException("Bid is already assigned to an Item");
        getBids().add(bid);
        bid.setItem(this);
    }
}
