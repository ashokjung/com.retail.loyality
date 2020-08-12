package com.retail.loyality.repository;

import com.retail.loyality.models.CustomerAddress;

public interface CustomerAddressDaoRepository {

    boolean addCustomerAddress(long customerId, CustomerAddress customerAddress) throws Exception;

    boolean updateCustomerAddress(long customerId, CustomerAddress customerAddress) throws Exception;
}
