package com.gradle.gradle.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "coffee_shop")
public class CoffeeShops {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "establishment")
    private String establishment;

    @Column(name = "description")
    private String description;

    @Column(name = "response")
    private String response;

    @NotNull
    @Column(name = "rating")
    private Integer rating;

    @Valid
    @Column(name = "phone_number")
    private String phoneNumber;

    @Valid
    @Column(name = "email")
    private String email;

    @Column(name = "creation_date")
    private LocalDate creationDate;
}




