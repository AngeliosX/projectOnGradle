package com.gradle.gradle.service;

import com.google.i18n.phonenumbers.NumberParseException;
import com.gradle.gradle.dto.in.CoffeeShopsInDTO;
import com.gradle.gradle.entity.CoffeeShops;
import com.gradle.gradle.exceptions.CoffeeShopsNotFoundException;
import com.gradle.gradle.exceptions.FoundationDateIsExpiredException;

import javax.validation.Valid;
import java.time.LocalDate;

public interface CoffeeShopsService {

    String getCoffeeShopsByEstablishment(String establishment) throws CoffeeShopsNotFoundException;

    CoffeeShops getResponseFromCoffeeShops(String establishment, String response);
    CoffeeShops getDescriptionFromCoffeeShops(String establishment, String description);
    CoffeeShops getRatingFromCoffeeShops(String establishment,Integer rating);

    CoffeeShops createShop(@Valid CoffeeShopsInDTO coffeeShop) throws NumberParseException, FoundationDateIsExpiredException;

    CoffeeShops createShopByNameAndDate(String name, LocalDate creation_date) throws FoundationDateIsExpiredException;
    LocalDate getCreationDate(Long id) throws CoffeeShopsNotFoundException;
}
