package net.example.coffeeshop.usecases.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
public class AvgCountCustomersByLastPeriodDTO {

    @Getter
    private Integer countOfCustomers;
}
