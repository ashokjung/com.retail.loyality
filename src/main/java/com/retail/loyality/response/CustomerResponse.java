package com.retail.loyality.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CustomerResponse {
    private boolean status;
    private String message;
    @JsonIgnore
    private String errormessage;


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }
}
