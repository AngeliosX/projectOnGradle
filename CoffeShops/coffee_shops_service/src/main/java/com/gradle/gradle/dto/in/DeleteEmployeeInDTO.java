package com.gradle.gradle.dto.in;

import com.gradle.gradle.entity.CoffeeShops;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class DeleteEmployeeInDTO {
    private Long id;
}
