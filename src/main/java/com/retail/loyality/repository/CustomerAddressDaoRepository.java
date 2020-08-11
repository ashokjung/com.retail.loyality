package com.retail.loyality.repository;

import com.retail.loyality.models.CustomerAddress;

public interface CustomerAddressDaoRepository {

    boolean addCustomerAddress(long customerId, CustomerAddress customerAddress);

    boolean updateCustomerAddress(long customerId, CustomerAddress customerAddress);
}
