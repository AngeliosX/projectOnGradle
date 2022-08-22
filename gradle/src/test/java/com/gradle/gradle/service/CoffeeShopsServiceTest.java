package com.gradle.gradle.service;

import com.gradle.gradle.AppContextTest;
import com.gradle.gradle.entity.CoffeeShops;
import com.gradle.gradle.exceptions.FoundationDateIsExpiredException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoffeeShopsServiceTest {
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    static
    class ResponseServiceTest extends AppContextTest {

        @Autowired
        CoffeeShopsService coffeeShopsService;


        @BeforeAll
        void ShopsWithoutResponse() throws FoundationDateIsExpiredException {
            CoffeeShops coffeeShops = new CoffeeShops(6L, "testShop6",
                    "", "very well", 5,
                    "+79998887766", "mail1@gmail.com", LocalDate.EPOCH);
            coffeeShopsService.createShopByNameAndDate(String.valueOf(coffeeShops),LocalDate.now());
        }

        @Test
        void getResponseFromShops() {
            String establishment = "tesShop1";
            String response = "not bad";
            CoffeeShops testResponse = coffeeShopsService.getResponseFromCoffeeShops(establishment, response);
            assertEquals(response, testResponse);
        }

        @Test
        void getDescriptionFromShops() {
            String establishment = "tesShop2";
            String description = "description for tstShop1";
            CoffeeShops testDescription = coffeeShopsService.getDescriptionFromCoffeeShops(establishment, description);
            assertEquals(description, testDescription);
        }
    }
}
