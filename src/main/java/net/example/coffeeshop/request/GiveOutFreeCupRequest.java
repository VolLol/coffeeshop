package net.example.coffeeshop.request;

import lombok.Getter;

public class GiveOutFreeCupRequest {

    @Getter
    private Long customerId;

    @Getter
    private Long shopId;
}
