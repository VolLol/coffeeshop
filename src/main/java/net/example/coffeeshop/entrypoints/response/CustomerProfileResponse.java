package net.example.coffeeshop.entrypoints.response;

import lombok.Builder;
import lombok.Getter;
import net.example.coffeeshop.entrypoints.enums.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public class CustomerProfileResponse {

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