package net.example.coffeeshop.response;

import lombok.Builder;
import lombok.Getter;
import net.example.coffeeshop.enums.Period;

@Builder
public class AvgCountCustomersByLastPeriodResponse {

    @Getter
    private Long shopId;

    @Getter
    private Period period;

    @Getter
    private Long avgCount;
}
