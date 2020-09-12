package net.example.coffeeshop.entrypoints.request;

import lombok.Getter;
import net.example.coffeeshop.entrypoints.enums.Reason;

import java.math.BigDecimal;


public class AddNewSaleRequest {


    @Getter
    private Long customerId;

    @Getter
    private Long shopId;

    @Getter
    private BigDecimal paid;

    @Getter
    private Reason reason;
}
