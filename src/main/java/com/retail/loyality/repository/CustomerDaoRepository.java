package com.retail.loyality.repository;

import com.retail.loyality.exception.CustomerException;
import com.retail.loyality.models.Customer;
import com.retail.loyality.response.CustomerResponse;

public interface CustomerDaoRepository {

    void  createCustomer(Customer customer) throws CustomerException;

    void updateCustomer(long customerId, Customer customer) throws CustomerException;
}
