package net.example.coffeeshop.entrypoints.response;

import lombok.Builder;
import lombok.Getter;
import net.example.coffeeshop.entrypoints.enums.Period;

@Builder
public class AvgCountCustomersByLastPeriodResponse {

    @Getter
    private Long shopId;

    @Getter
    private Period period;

    @Getter
    private Long avgCount;
}
