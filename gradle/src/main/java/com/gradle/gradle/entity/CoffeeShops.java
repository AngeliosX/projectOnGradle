package com.gradle.gradle.entity;

import lombok.*;

import javax.persistence.*;
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

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "creation_date")
    private LocalDate creationDate;
}




