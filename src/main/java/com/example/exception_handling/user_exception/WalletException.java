package com.example.exception_handling.user_exception;

public class WalletException extends RuntimeException{
    public WalletException(String message) {
        super(message);
    }
}
