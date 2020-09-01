package net.example.coffeeshop.response;

import lombok.Getter;

public class GiveOutFreeCupResponse {

    public GiveOutFreeCupResponse(String message) {
        this.message = message;
    }


    @Getter
    private String message;
}
