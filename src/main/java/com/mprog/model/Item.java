package com.mprog.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @Size(
            min = 2,
            max = 255,
            message = "Name is required, maximum 255 characters."
    )
    private String name;
    private String description;
    private LocalDate createdOn;
    private boolean verified;
//    private AuctionType auctionType;
    private BigDecimal initialPrice;
    private LocalDate auctionStart;
    @Future
    private LocalDate auctionEnd;
//    private Set<Bid> bids = new HashSet<>();
    private String imageName;

//    private User user;
//    private Category category;


//    public void addBid(Bid bid){
//        if (bid == null)
//            throw new NullPointerException("Can't add null Bid");
//        if (bid.getItem() != null)
//            throw new IllegalStateException("Bid is already assigned to an Item");
//        getBids().add(bid);
//        bid.setItem(this);
//    }
}
