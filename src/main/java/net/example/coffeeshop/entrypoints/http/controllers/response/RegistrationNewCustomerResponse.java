package net.example.coffeeshop.entrypoints.http.controllers.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationNewCustomerResponse {

    @Getter
    private String message;

    @Getter
    private HttpStatus httpStatus;


}
