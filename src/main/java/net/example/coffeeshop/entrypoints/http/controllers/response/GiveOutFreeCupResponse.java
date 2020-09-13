package net.example.coffeeshop.entrypoints.http.controllers.response;

import lombok.Getter;

public class GiveOutFreeCupResponse {

    public GiveOutFreeCupResponse(String message) {
        this.message = message;
    }


    @Getter
    private String message;
}
