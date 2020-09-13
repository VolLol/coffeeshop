package net.example.coffeeshop.entrypoints.http.controllers.response;

import lombok.Getter;

public class AddNewSaleResponse {

    public AddNewSaleResponse(String message) {
        this.message = message;
    }


    @Getter
    private String message;
}
