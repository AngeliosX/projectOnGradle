package com.gradle.gradle.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "coffee_shops_employees")
public class CoffeeShopsEmployees {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee")
    private String employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="shops", nullable=false)
    private CoffeeShops coffeeShops;


}
