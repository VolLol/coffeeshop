package net.example.coffeeshop.entrypoints.http.controllers.response;

import lombok.Builder;
import lombok.Getter;

@Builder
public class CustomerPropertiesResponse {

    public CustomerPropertiesResponse(String message) {
        this.message = message;
    }

    @Getter
    private String message;
}
