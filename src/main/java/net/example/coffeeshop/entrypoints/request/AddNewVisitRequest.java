package net.example.coffeeshop.entrypoints.request;

import lombok.Getter;
import net.example.coffeeshop.entrypoints.enums.Reason;

public class AddNewVisitRequest {


    @Getter
    private Long customerId;

    @Getter
    private Long shopId;

    @Getter
    private Long paid;

    @Getter
    private Reason reason;
}
