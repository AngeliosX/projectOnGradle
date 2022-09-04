package com.gradle.gradle.mappers;

import com.gradle.gradle.dto.in.UpdateEmployeeInDTO;
import com.gradle.gradle.dto.out.CoffeeShopsOutDTO;
import com.gradle.gradle.dto.in.DeleteEmployeeInDTO;
import com.gradle.gradle.entity.CoffeeShops;
import com.gradle.gradle.entity.CoffeeShopsEmployees;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CoffeeShopsMapper {

    DeleteEmployeeInDTO DELETE_EMPLOYEE_IN_DTO(CoffeeShopsEmployees coffeeShopsEmployees);
    UpdateEmployeeInDTO UPDATE_EMPLOYEE_IN_DTO(CoffeeShopsEmployees coffeeShopsEmployees);

            @Mappings({
            @Mapping(source = "establishment", target = "establishment"),
            @Mapping(target = "response", source = "response")
    })
    CoffeeShopsOutDTO responseEntityToResponseDTO(CoffeeShops coffeeShops);
}
