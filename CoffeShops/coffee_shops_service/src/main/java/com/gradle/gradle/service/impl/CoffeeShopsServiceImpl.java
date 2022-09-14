package com.gradle.gradle.service.impl;

import com.google.i18n.phonenumbers.NumberParseException;
import com.gradle.gradle.dto.in.CoffeeShopsInDTO;
import com.gradle.gradle.entity.CoffeeShops;
import com.gradle.gradle.exceptions.CoffeeShopsNotFoundException;
import com.gradle.gradle.exceptions.FoundationDateIsExpiredException;
import com.gradle.gradle.mappers.CoffeeShopsMapperMap;
import com.gradle.gradle.repository.CoffeeShopsRepository;
import com.gradle.gradle.service.CoffeeShopsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDate;

@Service
public class CoffeeShopsServiceImpl implements CoffeeShopsService {

    private final CoffeeShopsRepository coffeeShopsRepository;

    private final CoffeeShopsMapperMap coffeeShopsMapperMap;


    public CoffeeShopsServiceImpl(CoffeeShopsRepository coffeeShopsRepository, CoffeeShopsMapperMap coffeeShopsMapperMap) {
        this.coffeeShopsRepository = coffeeShopsRepository;
        this.coffeeShopsMapperMap = coffeeShopsMapperMap;
    }

    @Override
    public Page<CoffeeShops> getAllCoffeeShops(Pageable pageable) {
        return coffeeShopsRepository.findAll(pageable);
    }
    @Override
    public CoffeeShops getCoffeeShopsByEstablishment(String establishment) throws CoffeeShopsNotFoundException {
        CoffeeShops coffeeShops = coffeeShopsRepository.getEstablishmentFromCoffeeShops(establishment);
        if (coffeeShops == null) {
            throw new CoffeeShopsNotFoundException();
        } else {
            return coffeeShops;
        }
    }

    @Override
    public void updateDescriptionCoffeeShopsByEstablishment(String establishment, String description) throws CoffeeShopsNotFoundException {
        CoffeeShops coffeeShops = coffeeShopsRepository.findFirstByEstablishment(establishment);
        if (coffeeShops == null) {
            throw new CoffeeShopsNotFoundException();
        } else {
            coffeeShops.setDescription(description);
            coffeeShopsRepository.save(coffeeShops);
        }
    }


    @Override
    public CoffeeShops createShop(@Valid CoffeeShopsInDTO coffeeShop) throws NumberParseException, FoundationDateIsExpiredException {
        if (coffeeShop.getFoundationDate() == null || LocalDate.now().isBefore(coffeeShop.getFoundationDate())) {
            throw new FoundationDateIsExpiredException(coffeeShop.getEstablishment(), coffeeShop.getFoundationDate());
        }
        CoffeeShops coffeeShops = coffeeShopsMapperMap.coffeeShopsInDTOToCoffeeShopsEntity(coffeeShop);
        return coffeeShopsRepository.save(coffeeShops);
    }

    @Override
    public void createShopByNameAndDate(String establishment, LocalDate creationDate) throws FoundationDateIsExpiredException {
        if (creationDate == null || LocalDate.now().isBefore(creationDate)) {
            throw new FoundationDateIsExpiredException(establishment, creationDate);
        }
        CoffeeShops shops = new CoffeeShops(6L, "testShop6", "", "very well", 5, "+79998887766", "mail1@gmail.com", LocalDate.EPOCH);
        shops.setEstablishment(establishment);
        shops.setCreationDate(creationDate);
    }

    private CoffeeShops addCoffeeShops(CoffeeShops shops) {
        return shops;
    }

    @Override
    public LocalDate getCreationDate(Long id) {
        CoffeeShops shopsId = coffeeShopsRepository.getReferenceById(id);
        return shopsId.getCreationDate();
    }
}
