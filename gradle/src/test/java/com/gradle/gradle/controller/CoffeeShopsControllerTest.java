package com.gradle.gradle.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.gradle.gradle.dto.in.CoffeeShopsInDTO;
import com.gradle.gradle.service.CoffeeShopsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

public class CoffeeShopsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CoffeeShopsService coffeeShopsService;

    @Autowired
    private ObjectMapper objectMapper;

//    @Test
//    void getAllRestaurants() throws Exception {
//        String expected = objectMapper.writeValueAsString(coffeeShopsService.getAllCoffeeShops(Pageable.unpaged()));
//        this.mockMvc.perform(get("/coffeeShops/allCoffeeShops"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(content().json(expected));
//    }

    @Test
    public void validationTest() throws Exception {
        ObjectMapper objectMapper = new JsonMapper();
        CoffeeShopsInDTO dto = CoffeeShopsInDTO.builder()
                .establishment("")
                .foundationDate(LocalDate.now().plusDays(6))
                .telephoneNumber("090909")
                .email("test$@com")
                .build();
    }
}
