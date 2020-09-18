package net.example.coffeeshop.usecases.exceptions;

public class IncorrectGenderException extends Throwable {
    public IncorrectGenderException(String message) {
        super(message);
    }
}
