package com.retail.loyality.service;

import com.retail.loyality.models.Customer;

public interface CustomerService {

    boolean createCustomer(Customer customer) throws Exception;

    boolean updateCustomer(long customerId, Customer customer) throws Exception;

}
