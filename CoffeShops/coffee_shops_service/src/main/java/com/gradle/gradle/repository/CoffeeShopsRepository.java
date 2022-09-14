package com.gradle.gradle.repository;

import com.gradle.gradle.controller.CoffeeShopsController;
import com.gradle.gradle.entity.CoffeeShops;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CoffeeShopsRepository extends JpaRepository<CoffeeShops, Long> {

    @Query(value = "select establishment from coffee_shop where establishment = :establishment", nativeQuery = true)
    CoffeeShops getEstablishmentFromCoffeeShops(@Param("establishment") String establishment);
    @Query(value = "select establishment, response  from coffee_shop where response = :response", nativeQuery = true)
    CoffeeShops getResponseFromCoffeeShops(@Param("response") String response);

    @Query(value = "select establishment, description  from coffee_shop where description = :description", nativeQuery = true)
    CoffeeShops getDescriptionFromCoffeeShops(@Param("description") String description);

    @Query(value = "select establishment, rating  from coffee_shop where rating = :rating", nativeQuery = true)
    CoffeeShops getRatingFromCoffeeShops(@Param("rating") Integer rating);

    CoffeeShops findFirstByEstablishment(String establishment);

//    @Modifying
//    @Query("update coffee_shop as c set c.shops = :newShops where c.shops= :oldShops")
//    void updateUserSetStatusForName(@Param("newShops") Long newOwnerId, @Param("oldShops") Long oldShops);

//    @Query(value =
//            "select coffee_shop.id as id , max(coffee_shop.establishment) as name, avg(coffee_shop.rating) as avg " +
//                    "from coffee_shop " +
//                    "group by coffee_shop.id",
//            nativeQuery = true)
//    Page<CoffeeShopsController> averageRatingOfCoffeeShop(Pageable pageable);
}
