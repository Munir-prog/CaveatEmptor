package com.mprog;

import com.mprog.model.Item;
import com.mprog.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.ManagedType;
import javax.persistence.metamodel.Metamodel;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JavaApp {

    private static EntityManager em = null;

    public static void main(String[] args) {

//        var emf = getEMF();
//        var metamodel = emf.getMetamodel();
//        var managedTypes = metamodel.getManagedTypes();
//        for (ManagedType<?> managedType : managedTypes) {
//            System.out.println(managedType);
//        }

        insertItem(1, 1000, LocalDate.of(2021, 11, 21));
        insertItem(12, 10020, LocalDate.of(2021, 11, 21));
//        getItemByCriteria();
    }

    private static void getItemByCriteria() {
        var entityManager = getEntityManager();
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Item.class);

        var fromItem = query.from(Item.class);
        query.select(fromItem);

        var items = entityManager.createQuery(query).getResultList();
//        List<Order> orderList = new ArrayList<>();
//        orderList.add(criteriaBuilder.desc(fromItem.get("name")));
//        query.orderBy(orderList);
        Path<String> name = fromItem.get("name");
        query.where(
                criteriaBuilder.like(
                        name,
                        criteriaBuilder.parameter(String.class, "pattern")
                )
        );
        var items1 = entityManager.createQuery(query)
                .setParameter("pattern", "%item1%")
                .getResultList();
    }

    private static EntityManagerFactory getEMF(){
        return Persistence.createEntityManagerFactory("JavaApp");
    }

    private static EntityManager getEntityManager() {
        if (em == null) {
            EntityManagerFactory emf = getEMF();
            em = emf.createEntityManager();
            return em;
        }
        return em;
    }

    private static void insertItem(int itemNumber, int initialPrice, LocalDate dateEnd) {
        var entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        var item = new Item();
        item.setName("item" + itemNumber);
        item.setDescription("item" + itemNumber + "Desc");
        item.setCreatedOn(LocalDate.now());
        item.setVerified(true);
        item.setInitialPrice(BigDecimal.valueOf(initialPrice));
        item.setAuctionStart(LocalDate.now());
        item.setAuctionEnd(dateEnd);
        item.setImageName("item" + itemNumber + ".jpg");
        entityManager.persist(item);

        transaction.commit();
    }
}
