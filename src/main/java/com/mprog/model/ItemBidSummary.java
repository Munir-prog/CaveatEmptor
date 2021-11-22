package com.mprog.model;

import lombok.Getter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
@Immutable
@Subselect(
        value = "SELECT i.id AS itemId, i.item_name AS name," +
                "count(b.id) AS numberOfBids " +
                "from Item i LEFT OUTER JOIN Bid b ON i.id = b.item_id " +
                "GROUP BY i.id, i.item_name"
)
@Synchronize(
        {
                "Item",
                "Bid"
        }
)
public class ItemBidSummary {

    @Id
    private Long itemId;
    private String name;
    private Long numberOfBids;

    public ItemBidSummary() {
    }
}