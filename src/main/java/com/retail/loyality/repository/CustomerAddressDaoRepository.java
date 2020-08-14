package com.retail.loyality.repository;

import com.retail.loyality.exception.CustomerAddressException;
import com.retail.loyality.models.CustomerAddress;

public interface CustomerAddressDaoRepository {

    boolean addCustomerAddress(long customerId, CustomerAddress customerAddress) throws CustomerAddressException;

    boolean updateCustomerAddress(long customerId, CustomerAddress customerAddress) throws CustomerAddressException;
}
