package com.gradle.gradle.dao;

import com.gradle.gradle.entity.CoffeeShops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CoffeeShopsRepository extends JpaRepository<CoffeeShops, Long> {

    @Query(value = "select establishment, response  from coffee_shop where establishment = :establishment", nativeQuery = true)
    CoffeeShops getResponseFromShops(@Param("establishment") String response);

    @Query(value = "select establishment, description  from coffee_shop where establishment = :establishment", nativeQuery = true)
    CoffeeShops getDescriptionFromShops(@Param("establishment") String description);

    @Query(value = "select establishment, rating  from coffee_shop where establishment = :establishment", nativeQuery = true)
    CoffeeShops getRatingFromShops(@Param("establishment") String rating);
}
