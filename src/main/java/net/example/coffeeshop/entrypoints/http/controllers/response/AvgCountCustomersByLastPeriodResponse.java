package net.example.coffeeshop.entrypoints.http.controllers.response;

import lombok.Builder;
import lombok.Getter;
import net.example.coffeeshop.repositories.models.enums.Period;

@Builder
public class AvgCountCustomersByLastPeriodResponse {

    @Getter
    private Long shopId;

    @Getter
    private Period period;

    @Getter
    private Long avgCount;
}
