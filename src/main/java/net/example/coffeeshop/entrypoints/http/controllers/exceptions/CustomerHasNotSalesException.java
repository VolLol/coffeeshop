package net.example.coffeeshop.entrypoints.http.controllers.exceptions;

public class CustomerHasNotSalesException extends Throwable {
    public CustomerHasNotSalesException(String message) {
        super(message);
    }
}
