package com.retail.loyality.service;

import com.retail.loyality.models.Customer;
import com.retail.loyality.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class CustomerServiceImpl implements  CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public boolean createCustomer(Customer customer) {
        customerRepository.save(customer);
        return true;
    }

    public boolean updateCustomer(long customerId,Customer customer) {
        //Query query = new Query(where("id").is(customerId));
        //customerRepository.findOne(query,customer);
        return true;
    }
}
