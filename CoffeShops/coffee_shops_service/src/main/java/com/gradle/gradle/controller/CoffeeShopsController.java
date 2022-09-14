package com.gradle.gradle.controller;

import com.google.i18n.phonenumbers.NumberParseException;
import com.gradle.gradle.dto.in.CoffeeShopsInDTO;
import com.gradle.gradle.dto.out.CoffeeShopsOutDTO;
import com.gradle.gradle.exceptions.CoffeeShopsNotFoundException;
import com.gradle.gradle.exceptions.FoundationDateIsExpiredException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "user", description = "API of the users")
@RequestMapping("/coffeeShops")
public interface CoffeeShopsController {

    @Operation(summary = "Get all coffeeShops")
    @GetMapping
    Page<CoffeeShopsOutDTO> getAllCoffeeShops(Pageable pageable);

    @Operation(summary = "Update description by establishment")
    @PutMapping("/{establishment}/{description}")
    void updateDescriptionCoffeeShopsByEstablishment(@PathVariable String establishment, @PathVariable String description)
            throws CoffeeShopsNotFoundException;

    @Operation(summary = "Get description by establishment")
    @GetMapping("/{establishment}")
    String getDescriptionCoffeeShopsByEstablishment(@PathVariable String establishment)
            throws CoffeeShopsNotFoundException;

    @Operation(summary = "Add a coffeeShop")
    @PostMapping("/{coffeeShopsInDTO}")
    CoffeeShopsOutDTO addCoffeeShops(@Valid @RequestBody @PathVariable CoffeeShopsInDTO coffeeShopsInDTO)
            throws NumberParseException, FoundationDateIsExpiredException;
}
