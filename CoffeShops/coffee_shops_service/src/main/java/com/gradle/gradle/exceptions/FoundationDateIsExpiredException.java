package com.gradle.gradle.exceptions;

import java.time.LocalDate;

public class FoundationDateIsExpiredException extends Throwable {
    private final String establishmentName;
    private final LocalDate creationDate;

    public FoundationDateIsExpiredException(String establishmentName, LocalDate creationDate) {
        this.establishmentName = establishmentName;
        this.creationDate = creationDate;
    }


    @Override
    public String toString() {
        return "Restaurant with name \"" + establishmentName + "\"" +
                "has foundation date " + creationDate;
    }
}
