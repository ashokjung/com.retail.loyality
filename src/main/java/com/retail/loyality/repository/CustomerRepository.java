package com.retail.loyality.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.retail.loyality.models.Customer;

public interface CustomerRepository extends MongoRepository<Customer, Long> {


     //findOne(Query query, Customer customer);
}
