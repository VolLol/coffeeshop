package net.example.coffeeshop.entrypoints.http.controllers.exceptions;

public class CustomerHasNotEnoughPointsException extends Throwable {
    public CustomerHasNotEnoughPointsException(String message) {
        super(message);
    }
}
