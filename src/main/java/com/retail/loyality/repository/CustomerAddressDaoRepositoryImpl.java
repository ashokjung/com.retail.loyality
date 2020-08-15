package com.retail.loyality.repository;

import com.retail.loyality.exception.CustomerAddressException;
import com.retail.loyality.models.Customer;
import com.retail.loyality.models.CustomerAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerAddressDaoRepositoryImpl implements CustomerAddressDaoRepository {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerAddressDaoRepositoryImpl.class);
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MongoOperations mongoOperations;

    @Autowired
    private MongoTemplate mongoTemplate;

    public void addCustomerAddress(long customerId, CustomerAddress customerAddress) throws CustomerAddressException {
        try {
            LOG.info("Repository layer:Processing Add Customer Address Information ");

            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(customerId));
            query.fields().include("_id");

            Update update = new Update();
            update.set("customerAddress.addressLine1", customerAddress.getAddressLine1());
            update.set("customerAddress.addressLine2", customerAddress.getAddressLine2());
            update.set("customerAddress.addressLine3", customerAddress.getAddressLine3());
            update.set("customerAddress.state", customerAddress.getState());
            update.set("customerAddress.postalCode", customerAddress.getPostalCode());
            update.set("customerAddress.country", customerAddress.getCountry());
            mongoOperations.updateFirst(query, update, Customer.class);
        } catch (Exception e) {
            LOG.error("Repository layer:Processing Add Customer Address Information");
            throw new CustomerAddressException("Repository layer:Processing Add Customer Address Information errorMessage{} " + e.getMessage());
        }

    }

    public void updateCustomerAddress(long customerId, CustomerAddress customerAddress) throws CustomerAddressException {
        try {
            LOG.info("Repository layer:Processing Update Customer Address Information ");

            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(customerId));
            query.fields().include("_id");

            Update update = new Update();
            update.set("customerAddress.addressLine1", customerAddress.getAddressLine1());
            update.set("customerAddress.addressLine2", customerAddress.getAddressLine2());
            update.set("customerAddress.addressLine3", customerAddress.getAddressLine3());
            update.set("customerAddress.state", customerAddress.getState());
            update.set("customerAddress.postalCode", customerAddress.getPostalCode());
            update.set("customerAddress.country", customerAddress.getCountry());
            mongoOperations.updateFirst(query, update, Customer.class);
        } catch (Exception e) {
            LOG.error("Repository layer:Processing Update Customer Address Information  ");
            throw new CustomerAddressException("Repository layer:Processing Update Customer Address Information  errorMessage{} " + e.getMessage());
        }

    }
}
