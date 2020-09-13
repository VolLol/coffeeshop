package net.example.coffeeshop.usecases.dto;

import lombok.Builder;
import lombok.Getter;
import net.example.coffeeshop.repositories.models.enums.Gender;

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
    private Integer points;
    @Getter
    private LocalDateTime updateAt;
    @Getter
    private LocalDateTime createAt;
}
