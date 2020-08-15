package com.retail.loyality.exception;

public class ServiceExceptionHandler{

    private String status;
    private String message;

    public ServiceExceptionHandler(String message, String status) {
        super();
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }
}