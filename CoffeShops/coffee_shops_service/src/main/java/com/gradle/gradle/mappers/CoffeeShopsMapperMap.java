package com.gradle.gradle.mappers;

import com.google.i18n.phonenumbers.NumberParseException;
import com.gradle.gradle.controller.CoffeeShopsController;
import com.gradle.gradle.dto.in.CoffeeShopsInDTO;
import com.gradle.gradle.dto.out.CoffeeShopsOutDTO;
import com.gradle.gradle.entity.CoffeeShops;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class CoffeeShopsMapperMap {
    @Autowired
    private CoffeeShopsMapper coffeeShopsMapper;

    public abstract CoffeeShopsOutDTO coffeeShopsEntityToCoffeeShopsOutDTO(CoffeeShops coffeeShops);


    @Mapping(target = "response", ignore = true)
    @Mapping(target = "rating", ignore = true)
    @Mapping(target = "description", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "coffeeShopsEmployeesList", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "phoneNumber",
            expression = "java(com.gradle.gradle.util.UtilForPhoneNumber" +
                    ".reformatRuTelephone(coffeeShops.getTelephoneNumber()))"
    )
    public abstract CoffeeShops coffeeShopsInDTOToCoffeeShopsEntity(CoffeeShopsInDTO coffeeShops) throws NumberParseException;

    CoffeeShopsOutDTO reviewEntityToReviewOutDTO(CoffeeShops coffeeShops) {
        return coffeeShopsMapper.responseEntityToResponseDTO(coffeeShops);
    }


    public CoffeeShopsController coffeeShopsToCoffeeShopsOutDTO(CoffeeShopsController coffeeShopsController) {

        return coffeeShopsController;
    }
}
