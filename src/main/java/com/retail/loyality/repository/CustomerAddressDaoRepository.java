package com.retail.loyality.repository;

import com.retail.loyality.exception.CustomerAddressException;
import com.retail.loyality.models.CustomerAddress;

public interface CustomerAddressDaoRepository {

    void addCustomerAddress(long customerId, CustomerAddress customerAddress) throws CustomerAddressException;

    void updateCustomerAddress(long customerId, CustomerAddress customerAddress) throws CustomerAddressException;
}
