package net.example.coffeeshop.request;

import lombok.Getter;
import net.example.coffeeshop.enums.Reason;

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
