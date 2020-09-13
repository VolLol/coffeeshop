package net.example.coffeeshop.entrypoints.http.controllers.request;

import lombok.Getter;
import net.example.coffeeshop.repositories.models.enums.Reason;

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
