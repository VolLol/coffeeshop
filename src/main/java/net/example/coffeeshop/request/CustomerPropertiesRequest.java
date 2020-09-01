package net.example.coffeeshop.request;

import lombok.Getter;
import net.example.coffeeshop.enums.Gender;

import java.time.LocalDate;

public class CustomerPropertiesRequest {

    @Getter
    private Long customerId;

    @Getter
    private Gender gender;

    @Getter
    private LocalDate dateOfBirth;
}
