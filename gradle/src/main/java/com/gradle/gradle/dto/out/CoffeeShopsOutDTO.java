package com.gradle.gradle.dto.out;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoffeeShopsOutDTO {
    private Long id;
    private String establishment;
    private String description;
    private String response;
    private Integer rating;
    private String phoneNumber;
    private String email;
    private LocalDate creationDate;
}