package net.example.coffeeshop.entrypoints.http.controllers.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.example.coffeeshop.repositories.models.enums.Gender;

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
    private Integer points;
    @Getter
    private LocalDateTime updateAt;
    @Getter
    private LocalDateTime createAt;

}