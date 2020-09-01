package net.example.coffeeshop.response;

import lombok.Getter;

public class CustomerPropertiesResponse {

    public CustomerPropertiesResponse(String message) {
        this.message = message;
    }

    @Getter
    private String message;
}
