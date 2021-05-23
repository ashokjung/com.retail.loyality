package com.retail.loyality.service;

import com.retail.loyality.exception.CustomerAddressException;
import com.retail.loyality.models.CustomerAddress;
import com.retail.loyality.response.CustomerResponse;

public interface CustomerAddressService {

    CustomerResponse addCustomerAddress(long customerId, CustomerAddress customerAddress)
            throws CustomerAddressException;

    CustomerResponse updateCustomerAddress(long customerId, CustomerAddress customerAddress)
            throws CustomerAddressException;
}
