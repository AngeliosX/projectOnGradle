package com.gradle.gradle.controller.impl;

import com.google.i18n.phonenumbers.NumberParseException;
import com.gradle.gradle.controller.CoffeeShopsController;
import com.gradle.gradle.dto.in.CoffeeShopsInDTO;
import com.gradle.gradle.dto.out.CoffeeShopsOutDTO;
import com.gradle.gradle.entity.CoffeeShops;
import com.gradle.gradle.exceptions.CoffeeShopsNotFoundException;
import com.gradle.gradle.exceptions.FoundationDateIsExpiredException;
import com.gradle.gradle.mappers.CoffeeShopsMapperMap;
import com.gradle.gradle.service.CoffeeShopsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CoffeeShopsControllerImpl implements CoffeeShopsController {
    private final CoffeeShopsService coffeeShopsService;
    private final CoffeeShopsMapperMap coffeeShopsMapper;

    public CoffeeShopsControllerImpl(CoffeeShopsService coffeeShopsService, CoffeeShopsMapperMap coffeeShopsMapper) {
        this.coffeeShopsService = coffeeShopsService;
        this.coffeeShopsMapper = coffeeShopsMapper;
    }

    @Override
    public Page<CoffeeShopsOutDTO> getAllCoffeeShops(@PageableDefault(sort = "establishment") Pageable pageable) {
        Page<CoffeeShops> coffeeShopsPage = coffeeShopsService.getAllCoffeeShops(pageable);
        return coffeeShopsPage.map(coffeeShopsMapper::coffeeShopsEntityToCoffeeShopsOutDTO);
    }

    @Override
    public void updateDescriptionCoffeeShopsByEstablishment(@PathVariable String establishment, @PathVariable String description) throws CoffeeShopsNotFoundException {
        coffeeShopsService.updateDescriptionCoffeeShopsByEstablishment(establishment, description);
    }

    @Override
    public String getDescriptionCoffeeShopsByEstablishment(@PathVariable String establishment) throws CoffeeShopsNotFoundException {
        CoffeeShops coffeeShops = coffeeShopsService.getCoffeeShopsByEstablishment(establishment);
        return coffeeShopsMapper.coffeeShopsEntityToCoffeeShopsOutDTO(coffeeShops).getDescription();
    }

    @Override
    public CoffeeShopsOutDTO addCoffeeShops(@Valid @RequestBody CoffeeShopsInDTO coffeeShopsInDTO) throws NumberParseException, FoundationDateIsExpiredException {
        CoffeeShops coffeeShops = coffeeShopsService.createShop(coffeeShopsInDTO);
        return coffeeShopsMapper.coffeeShopsEntityToCoffeeShopsOutDTO(coffeeShops);
    }

}
