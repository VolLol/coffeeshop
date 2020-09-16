package net.example.coffeeshop.entrypoints.http.controllers.exceptions;

public class ShopNotExistException extends Throwable {
    public ShopNotExistException(String message) {
        super(message);
    }
}
