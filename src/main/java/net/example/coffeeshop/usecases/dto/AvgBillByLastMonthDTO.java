package net.example.coffeeshop.usecases.dto;


import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
public class AvgBillByLastMonthDTO {

    @Getter
    private BigDecimal avgBill;
}
