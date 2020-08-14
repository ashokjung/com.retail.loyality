package com.retail.loyality.exception;

public class CustomerException extends Exception {

    public CustomerException() {

    }

    public CustomerException(String message) {
        super(message);
    }

    public CustomerException(String message, Throwable cause) {
        super(message, cause);
    }

}
