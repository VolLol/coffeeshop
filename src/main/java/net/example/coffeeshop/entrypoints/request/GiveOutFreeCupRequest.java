package net.example.coffeeshop.entrypoints.request;

import lombok.Getter;

public class GiveOutFreeCupRequest {

    @Getter
    private Long customerId;

    @Getter
    private Long shopId;
}
