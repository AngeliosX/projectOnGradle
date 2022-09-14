package com.gradle.gradle.service;

import com.google.i18n.phonenumbers.NumberParseException;
import com.gradle.gradle.dto.in.CoffeeShopsInDTO;
import com.gradle.gradle.entity.CoffeeShops;
import com.gradle.gradle.exceptions.CoffeeShopsNotFoundException;
import com.gradle.gradle.exceptions.FoundationDateIsExpiredException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.time.LocalDate;

public interface CoffeeShopsService {

    Page<CoffeeShops> getAllCoffeeShops(Pageable pageable);

    CoffeeShops getCoffeeShopsByEstablishment(String establishment) throws CoffeeShopsNotFoundException;

    void updateDescriptionCoffeeShopsByEstablishment(String establishment, String description) throws CoffeeShopsNotFoundException;

    CoffeeShops createShop(@Valid CoffeeShopsInDTO coffeeShop) throws NumberParseException, FoundationDateIsExpiredException;

    void createShopByNameAndDate(String name, LocalDate creation_date) throws FoundationDateIsExpiredException;
    LocalDate getCreationDate(Long id) throws CoffeeShopsNotFoundException;
}
