package com.retail.loyality.service;

import com.retail.loyality.models.CustomerAddress;

public interface CustomerAddressService {

    boolean addCustomerAddress(long CustomerId,CustomerAddress customerAddress);
    boolean updateCustomerAddress(long CustomerId,CustomerAddress customerAddress);
}
