package com.gradle.gradle.exceptions;

public class CoffeeShopsNotFoundException extends Exception {
    private Long establishmentId;

    public CoffeeShopsNotFoundException() {
        this.establishmentId = establishmentId;
    }

    public Long getEstablishmentId() {
        return establishmentId;
    }
}