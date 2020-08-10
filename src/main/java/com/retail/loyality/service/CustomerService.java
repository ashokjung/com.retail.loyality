package com.retail.loyality.service;

import com.retail.loyality.models.Customer;

public interface CustomerService {

    boolean createCustomer(Customer customer);

    boolean updateCustomer(long customerId, Customer customer);

}
