package net.example.coffeeshop.entrypoints.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class RegistrationNewCustomerResponse {

    public RegistrationNewCustomerResponse(String message) {
        this.message = message;
    }

    @Setter
    @Getter
    private String message;
}
