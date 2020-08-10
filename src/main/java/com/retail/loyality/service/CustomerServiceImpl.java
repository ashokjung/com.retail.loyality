package com.retail.loyality.service;

import com.retail.loyality.models.Customer;
import com.retail.loyality.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private CustomerRepository customerRepository;

    public boolean createCustomer(Customer customer) {
        customerRepository.save(customer);
        return true;
    }

    public boolean updateCustomer(long customerId, Customer customer) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(customerId));
        Update update = new Update();
        update.set("firstName", customer.getFirstName());
        update.set("lastName", customer.getLastName());
        mongoTemplate.findAndModify(query, update, Customer.class);
        return true;
    }
}
