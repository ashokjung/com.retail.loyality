package com.retail.loyality.service;

import com.retail.loyality.models.Customer;
import com.retail.loyality.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements  CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public boolean createCustomer(Customer customer) {
        customerRepository.save(customer);
        return true;
    }

    public boolean updateCustomer(long customerId,Customer customer) {
        return true;
    }
}
