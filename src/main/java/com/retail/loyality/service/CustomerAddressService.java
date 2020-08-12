package com.retail.loyality.service;

import com.retail.loyality.models.CustomerAddress;

public interface CustomerAddressService {

    boolean addCustomerAddress(long customerId, CustomerAddress customerAddress) throws Exception;

    boolean updateCustomerAddress(long customerId, CustomerAddress customerAddress) throws Exception;
}
