package net.example.coffeeshop.entrypoints.response;

import lombok.Getter;

public class RegistrationNewCustomerResponse {

    public RegistrationNewCustomerResponse(String message) {
        this.message = message;
    }

    @Getter
    private String message;
}
