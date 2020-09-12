package net.example.coffeeshop.entrypoints.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.example.coffeeshop.entrypoints.enums.Gender;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
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
    private BigDecimal points;
    @Getter
    private LocalDateTime updateAt;
    @Getter
    private LocalDateTime createAt;

}