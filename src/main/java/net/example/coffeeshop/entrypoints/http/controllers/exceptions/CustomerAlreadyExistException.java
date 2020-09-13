package net.example.coffeeshop.entrypoints.http.controllers.exceptions;

public class CustomerAlreadyExistException extends Throwable {

    public CustomerAlreadyExistException(String message) {
        super(message);
    }
}
