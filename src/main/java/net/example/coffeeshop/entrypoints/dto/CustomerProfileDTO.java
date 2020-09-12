package net.example.coffeeshop.entrypoints.dto;

import lombok.Builder;
import lombok.Getter;
import net.example.coffeeshop.entrypoints.enums.Gender;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public class CustomerProfileDTO {

    @Getter
    private Long customerId;
    @Getter
    private Long telegramId;
    @Getter
    private LocalDate yearOfBirth;
    @Getter
    private Gender gender;
    @Getter
    private BigDecimal points;
    @Getter
    private LocalDateTime updateAt;
    @Getter
    private LocalDateTime createAt;
}