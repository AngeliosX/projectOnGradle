package com.gradle.gradle.exceptions;

public class CoffeeShopsNotFoundException extends Exception {
    private final Long establishmentId;

    public CoffeeShopsNotFoundException(Long establishmentId) {
        this.establishmentId = establishmentId;
    }

    public Long getEstablishmentId() {
        return establishmentId;
    }
}