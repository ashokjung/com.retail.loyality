package com.retail.loyality.repository;

import com.retail.loyality.models.Customer;

public interface CustomerDaoRepository {

    boolean createCustomer(Customer customer) throws Exception;

    boolean updateCustomer(long customerId, Customer customer) throws Exception;
}
