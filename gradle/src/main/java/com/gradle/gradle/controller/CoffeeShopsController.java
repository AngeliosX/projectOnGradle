package com.gradle.gradle.controller;

import com.google.i18n.phonenumbers.NumberParseException;
import com.gradle.gradle.dto.in.CoffeeShopsInDTO;
import com.gradle.gradle.dto.out.CoffeeShopsOutDTO;
import com.gradle.gradle.entity.CoffeeShops;
import com.gradle.gradle.exceptions.FoundationDateIsExpiredException;
import com.gradle.gradle.mappers.CoffeeShopsMapperMap;
import com.gradle.gradle.service.CoffeeShopsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CoffeeShopsController {
    private final CoffeeShopsService coffeeShopsService;
    private final CoffeeShopsMapperMap coffeeShopsMapper;

    public CoffeeShopsController(CoffeeShopsService coffeeShopsService, CoffeeShopsMapperMap coffeeShopsMapper) {
        this.coffeeShopsService = coffeeShopsService;
        this.coffeeShopsMapper = coffeeShopsMapper;
    }

    @GetMapping("/response")
    public CoffeeShops getResponseFromShops(String response) {
        return coffeeShopsService.getResponseFromShops(response);
    }


    @GetMapping("/description")
    public CoffeeShops getDescriptionFromShops(String description) {
        return coffeeShopsService.getDescriptionFromShops(description);
    }

    @GetMapping("/rating")
    public CoffeeShops getRatingFromShops(String rating) {
        return coffeeShopsService.getRatingFromShops(rating);
    }

    @PostMapping("/shop")
    public CoffeeShopsOutDTO addCoffeeShops(@Valid @RequestBody CoffeeShopsInDTO coffeeShopsInDTO) throws NumberParseException, FoundationDateIsExpiredException {
        CoffeeShops coffeeShops = coffeeShopsService.createShop(coffeeShopsInDTO);
        return coffeeShopsMapper.coffeeShopsEntityToCoffeeShopsOutDTO(coffeeShops);
    }

}
