package net.example.coffeeshop.entrypoints.http.controllers.response.models;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
public class MonthlyReportModel {

    @Getter
    private Long shopId;
    @Getter
    private String shopAddress;
    @Getter
    private BigDecimal spentMoney;
}
