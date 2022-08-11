package com.gradle.gradle.service.impl;

import com.google.i18n.phonenumbers.NumberParseException;
import com.gradle.gradle.config.DataConfig;
import com.gradle.gradle.dao.CoffeeShopsRepository;
import com.gradle.gradle.dto.in.CoffeeShopsInDTO;
import com.gradle.gradle.entity.CoffeeShops;
import com.gradle.gradle.exceptions.FoundationDateIsExpiredException;
import com.gradle.gradle.mappers.CoffeeShopsMapperMap;
import com.gradle.gradle.service.CoffeeShopsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import static com.gradle.gradle.config.DataConfig.url;

@Service
// не хватает обработки если не нашли кофе шоп
public class CoffeeShopsServiceImpl implements CoffeeShopsService {

    private final CoffeeShopsRepository coffeeShopsRepository;

    private final CoffeeShopsMapperMap coffeeShopsMapperMap;
    private static final Logger log = LoggerFactory.getLogger(CoffeeShopsServiceImpl.class);

    public CoffeeShopsServiceImpl(DataConfig dataConfig, CoffeeShopsRepository coffeeShopsRepository, CoffeeShopsMapperMap coffeeShopsMapperMap) {
        this.dataConfig = dataConfig;
        this.coffeeShopsRepository = coffeeShopsRepository;
        this.coffeeShopsMapperMap = coffeeShopsMapperMap;
    }

    @Override
    public CoffeeShops getResponseFromShops(String response) {
        return coffeeShopsRepository.getResponseFromShops(response);
    }

    @Override
    public CoffeeShops getDescriptionFromShops(String description) {
        return coffeeShopsRepository.getDescriptionFromShops(description);
    }

    @Override
    public CoffeeShops getRatingFromShops(String rating) {
        return coffeeShopsRepository.getRatingFromShops(rating);
    }

    @Override
    public CoffeeShops createShop(CoffeeShopsInDTO coffeeShop) throws NumberParseException, FoundationDateIsExpiredException {
        if (coffeeShop.getFoundationDate() == null || LocalDate.now().isBefore(coffeeShop.getFoundationDate())) {
            throw new FoundationDateIsExpiredException(coffeeShop.getEstablishment(), coffeeShop.getFoundationDate());
        }

        CoffeeShops coffeeShops = coffeeShopsMapperMap.coffeeShopsInDTOToCoffeeShopsEntity(coffeeShop);
        return coffeeShopsRepository.save(coffeeShops);
    }

    @Override
    public long createShopByNameAndDate(String establishment, LocalDate creationDate) throws FoundationDateIsExpiredException {
        if (creationDate == null || LocalDate.now().isBefore(creationDate)) {
            throw new FoundationDateIsExpiredException(establishment, creationDate);
        }
        CoffeeShops shops = new CoffeeShops();
        shops.setEstablishment(establishment);
        shops.setCreationDate(creationDate);
        CoffeeShops save = coffeeShopsRepository.save(shops);
        return save.getId();
    }

    @Override
    public LocalDate getCreationDate(Long id) {
        CoffeeShops shopsId = coffeeShopsRepository.getReferenceById(id);
        return shopsId.getCreationDate();
    }
}
