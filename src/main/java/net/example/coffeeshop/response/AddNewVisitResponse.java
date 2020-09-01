package net.example.coffeeshop.response;

import lombok.Getter;

public class AddNewVisitResponse {

    public AddNewVisitResponse(String message) {
        this.message = message;
    }


    @Getter
    private String message;
}
