package net.example.coffeeshop.entrypoints.http.controllers.response;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
public class AverageBillByLastMonthResponse {


    @Getter
    private Long shopId;

    @Getter
    private BigDecimal avgBill;
}
