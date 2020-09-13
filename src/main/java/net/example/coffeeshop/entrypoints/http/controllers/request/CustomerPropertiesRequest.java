package net.example.coffeeshop.entrypoints.http.controllers.request;

import lombok.Getter;
import net.example.coffeeshop.repositories.models.enums.Gender;

import java.time.LocalDate;

public class CustomerPropertiesRequest {

    @Getter
    private Long customerId;

    @Getter
    private Gender gender;

    @Getter
    private LocalDate dateOfBirth;
}
