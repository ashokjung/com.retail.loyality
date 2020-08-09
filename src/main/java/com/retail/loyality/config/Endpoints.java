package com.retail.loyality.config;

public interface Endpoints {

    public static final String baseurl = "/api/v1";
    public static final String addCustomer = baseurl+"/customer";
    public static final String updateCustomer = baseurl+"/customer/{customerId}";
    public static final String updateCustomerAddress = baseurl+"/customer/address/{customerId}";
    public static final String updateCustomerContactDetails = baseurl+"/customer/contact/{customerId}";
}
