package com.gradle.gradle.dto.in;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.gradle.gradle.validator.annotation.EmailConstraint;
import com.gradle.gradle.validator.annotation.PhoneNumberConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
public class CoffeeShopsInDTO {
    @NotBlank(message = "пустое имя")
    private final String establishment;
    @PhoneNumberConstraint(message = "телефонный номер не соответсвует формату")
    private final String telephoneNumber;
    @EmailConstraint(message = "не верный формат e-mail")
    private final String email;

    @DateTimeFormat(pattern = "YYYY-MM-DD")
    @JsonSerialize(using = LocalDateSerializer.class)
    private final LocalDate foundationDate;
}
