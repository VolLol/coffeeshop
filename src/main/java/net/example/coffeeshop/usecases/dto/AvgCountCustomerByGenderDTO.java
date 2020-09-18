package net.example.coffeeshop.usecases.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
public class AvgCountCustomerByGenderDTO {

    @Getter
    private Long count;
}
