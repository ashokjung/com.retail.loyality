package com.retail.loyality.exception;

public class CustomerAddressException extends Exception {

    public CustomerAddressException() {

    }

    public CustomerAddressException(String message) {
        super(message);
    }

    public CustomerAddressException(String message, Throwable cause) {
        super(message, cause);
    }
}
