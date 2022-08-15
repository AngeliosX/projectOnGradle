package com.gradle.gradle.utils;

import com.gradle.gradle.entity.CoffeeShops;
import com.gradle.gradle.exceptions.CoffeeShopsNotFoundException;
import com.gradle.gradle.exceptions.FoundationDateIsExpiredException;
import com.gradle.gradle.service.CoffeeShopsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mockStatic;

public class UtilDateTest {
    @Autowired
    private CoffeeShopsService coffeeShopsService;

    @Test
    void createShopByNameAndDate() throws CoffeeShopsNotFoundException, NullPointerException, FoundationDateIsExpiredException {
        MockedStatic<LocalDate> localDateMockedStatic = mockStatic(LocalDate.class, CALLS_REAL_METHODS);
        LocalDate defaultNow = LocalDate.of(2018, 7, 8);
        localDateMockedStatic.when(LocalDate::now).thenReturn(defaultNow);

        Assertions.assertThrowsExactly(FoundationDateIsExpiredException.class,
                () -> coffeeShopsService.createShopByNameAndDate("shop6", LocalDate.now().plusDays(5)));

        LocalDate creationDate = LocalDate.now().minusDays(5);
        CoffeeShops testShop = coffeeShopsService.createShopByNameAndDate("testShop", creationDate);
        assertTrue(creationDate.isEqual(coffeeShopsService.getCreationDate(testShop.getId())));
    }
}
