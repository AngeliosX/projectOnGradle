package com.gradle.gradle.service;

import com.google.i18n.phonenumbers.NumberParseException;
import com.gradle.gradle.dto.in.CoffeeShopsInDTO;
import com.gradle.gradle.entity.CoffeeShops;
import com.gradle.gradle.exceptions.CoffeeShopsNotFoundException;
import com.gradle.gradle.exceptions.FoundationDateIsExpiredException;

import java.time.LocalDate;

public interface CoffeeShopsService {

    CoffeeShops getResponseFromShops(String response);
    CoffeeShops getDescriptionFromShops(String description);
    CoffeeShops getRatingFromShops(String rating);

    CoffeeShops createShop(CoffeeShopsInDTO coffeeShop) throws NumberParseException, FoundationDateIsExpiredException;

    long createShopByNameAndDate(String name, LocalDate creation_date) throws FoundationDateIsExpiredException;
    LocalDate getCreationDate(Long id) throws CoffeeShopsNotFoundException;
}
