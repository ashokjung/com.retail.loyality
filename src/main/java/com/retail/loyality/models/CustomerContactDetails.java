package com.retail.loyality.models;

public class CustomerContactDetails {

    private long customerId;
    private String mobilePhoneNumber;
    private String daytimePhoneNumber;
    private String eveningPhoneNumber;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getDaytimePhoneNumber() {
        return daytimePhoneNumber;
    }

    public void setDaytimePhoneNumber(String daytimePhoneNumber) {
        this.daytimePhoneNumber = daytimePhoneNumber;
    }

    public String getEveningPhoneNumber() {
        return eveningPhoneNumber;
    }

    public void setEveningPhoneNumber(String eveningPhoneNumber) {
        this.eveningPhoneNumber = eveningPhoneNumber;
    }
}
