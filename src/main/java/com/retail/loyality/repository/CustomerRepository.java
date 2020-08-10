package com.retail.loyality.repository;

import com.retail.loyality.models.Customer;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, Long> {


     //findOne(Query query, Customer customer);
}
