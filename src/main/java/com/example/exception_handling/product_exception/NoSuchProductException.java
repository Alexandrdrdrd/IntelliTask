package com.example.exception_handling.product_exception;

public class NoSuchProductException extends RuntimeException{
    public NoSuchProductException(String message) {
        super(message);
    }
}
