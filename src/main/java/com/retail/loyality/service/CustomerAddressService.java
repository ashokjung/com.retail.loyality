package com.retail.loyality.service;

import com.retail.loyality.models.CustomerAddress;

public interface CustomerAddressService {

    boolean addCustomerAddress(long customerId,CustomerAddress customerAddress);
    boolean updateCustomerAddress(long customerId,CustomerAddress customerAddress);
}
