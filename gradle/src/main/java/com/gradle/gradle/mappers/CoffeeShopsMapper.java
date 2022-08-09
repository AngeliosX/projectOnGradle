package com.gradle.gradle.mappers;

import com.gradle.gradle.dto.out.CoffeeShopsOutDTO;
import com.gradle.gradle.entity.CoffeeShops;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CoffeeShopsMapper {

    @Mappings({
            @Mapping(source = "establishment", target = "establishment"),
            @Mapping(source = "creationDate", target = "creationDate"),
            @Mapping(target = "description", source = "description"),
            @Mapping(target = "rating", source = "rating"),
            @Mapping(target = "response", source = "response")
    })
    CoffeeShopsOutDTO responseEntityToResponseDTO(CoffeeShops coffeeShops);
}
