package com.gradle.gradle.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

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

    @OneToMany(mappedBy= "establishment"
            , cascade = CascadeType.REFRESH
            , fetch = FetchType.LAZY)
    private List<CoffeeShopsEmployees> coffeeShopsEmployeesList;



    public CoffeeShops(Long id, String establishment, String description, String response, Integer rating, String phoneNumber, String email, LocalDate creationDate) {
        this.id = id;
        this.establishment = establishment;
        this.description = description;
        this.response = response;
        this.rating = rating;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.creationDate = creationDate;
    }
}




