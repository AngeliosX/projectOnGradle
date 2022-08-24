package com.gradle.gradle.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.gradle.gradle.dto.in.CoffeeShopsInDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CoffeeShopsControllerTest {

//    @Autowired
//    private MockMvc mockMvc;

    @Test
    public void validationTest() throws Exception {
        ObjectMapper objectMapper = new JsonMapper();
        CoffeeShopsInDTO dto = CoffeeShopsInDTO.builder()
                .establishment("")
                .foundationDate(LocalDate.now().plusDays(6))
                .telephoneNumber("090909")
                .email("test$@com")
                .build();

//        this.mockMvc.perform(post("/shop")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(dto)))
//                .andDo(print()) //print response in console
//                .andExpect(status().is4xxClientError())
//                .andExpect(content().json("{\"name\":\"пустое имя\"," +
//                                "\"telephoneNumber\": \"телефонный номер не соответсвует формату\"," +
//                                 "\"email\": \"проверьте формат электронного адреса\"}"
//                ));// check status
    }
}
