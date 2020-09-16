package net.example.coffeeshop.entrypoints.http.controllers.request;

import lombok.Getter;

import java.math.BigDecimal;


public class AddNewSaleRequest {


    @Getter
    private Long customerId;

    @Getter
    private Long shopId;

    @Getter
    private BigDecimal paid;

}
