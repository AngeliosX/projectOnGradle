package com.gradle.gradle.service;

import com.gradle.gradle.AppContextTest;
import com.gradle.gradle.entity.CoffeeShops;
import com.gradle.gradle.exceptions.FoundationDateIsExpiredException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class CoffeeShopsServiceTest {
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    static
    class ResponseServiceTest extends AppContextTest {

        @Autowired
        CoffeeShopsService coffeeShopsService;


        @BeforeAll
        void ShopsWithoutResponse() throws FoundationDateIsExpiredException {
            CoffeeShops coffeeShops = new CoffeeShops();
            coffeeShops.setId(6L);
            coffeeShops.setEstablishment("testShop6");
            coffeeShops.setDescription("description for testShop6");
            coffeeShops.setResponse("");
            coffeeShops.setRating(5);
            coffeeShops.setPhoneNumber("+79998887766");
            coffeeShops.setEmail("mail1@gmail.com");
            coffeeShops.setCreationDate(LocalDate.now());


            coffeeShopsService.createShopByNameAndDate(String.valueOf(coffeeShops),LocalDate.now());
        }
//
//        @Test
//        @Transactional
//        void testTransactional(String  establishment) throws CoffeeShopsNotFoundException {
//            CoffeeShops coffeeShops = coffeeShopsService.getCoffeeShopsByEstablishment(establishment);
//            for (CoffeeShopsEmployees coffeeShopsEmployees : coffeeShops.getCoffeeShopsEmployeesList()) {
//                System.out.println(coffeeShopsEmployees.getCoffeeShops());
//                System.out.println(coffeeShopsEmployees.getEmployee());
//            }
//        }

    }
}
