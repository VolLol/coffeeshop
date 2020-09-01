package net.example.coffeeshop.response;

import lombok.Getter;

public class RegistrationNewCustomerResponse {

    public RegistrationNewCustomerResponse(String message) {
        this.message = message;
    }

    @Getter
    private String message;
}
