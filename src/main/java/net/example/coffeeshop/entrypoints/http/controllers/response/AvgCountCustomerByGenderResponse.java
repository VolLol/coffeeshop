package net.example.coffeeshop.entrypoints.http.controllers.response;

import lombok.Builder;
import lombok.Getter;

@Builder
public class AvgCountCustomerByGenderResponse {

    @Getter
    private String message;

    @Getter
    private Long avgCount;

}
