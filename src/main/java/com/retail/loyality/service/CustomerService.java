package com.retail.loyality.service;

import com.retail.loyality.exception.CustomerException;
import com.retail.loyality.models.Customer;
import com.retail.loyality.response.CustomerResponse;

public interface CustomerService {

    CustomerResponse createCustomer(Customer customer) throws CustomerException;

    CustomerResponse updateCustomer(long customerId, Customer customer) throws CustomerException;

}
