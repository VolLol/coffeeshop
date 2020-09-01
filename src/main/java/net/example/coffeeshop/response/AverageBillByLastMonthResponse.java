package net.example.coffeeshop.response;

import lombok.Builder;
import lombok.Getter;

@Builder
public class AverageBillByLastMonthResponse {


    @Getter
    private Long shopId;

    @Getter
    private Long avgBill;
}
