package net.example.coffeeshop.entrypoints.http.controllers.exceptions;

public class CustomerNotExistException extends Throwable {
    public CustomerNotExistException(String message) {
        super(message);
    }
}
