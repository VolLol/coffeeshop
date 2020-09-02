package net.example.coffeeshop.entrypoints.response;

import lombok.Getter;

public class AddNewVisitResponse {

    public AddNewVisitResponse(String message) {
        this.message = message;
    }


    @Getter
    private String message;
}
