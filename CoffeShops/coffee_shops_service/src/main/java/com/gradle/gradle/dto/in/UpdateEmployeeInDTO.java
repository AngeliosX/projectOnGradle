package com.gradle.gradle.dto.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class UpdateEmployeeInDTO {
    private Long id;
}
