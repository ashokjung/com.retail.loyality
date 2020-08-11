package com.retail.loyality.repository;

import com.retail.loyality.models.Customer;
import com.retail.loyality.models.CustomerContactDetails;
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
public class CustomerContactDaoRepositoryImpl implements CustomerContactDaoRepository{

    private static final Logger LOG = LoggerFactory.getLogger(CustomerContactDaoRepositoryImpl.class);
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MongoOperations mongoOperations;

    @Autowired
    private MongoTemplate  mongoTemplate;
    public boolean addCustomerContact(long customerId, CustomerContactDetails customerContactDetails) throws Exception {
        try {
            LOG.info("Repository layer:Processing Create Customer Contact Information ");

            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(customerId));
            query.fields().include("_id");

            Update update = new Update();
            update.set("customerContactDetails.mobilePhoneNumber",customerContactDetails.getMobilePhoneNumber());
            update.set("customerContactDetails.daytimePhoneNumber",customerContactDetails.getDaytimePhoneNumber());
            update.set("customerContactDetails.eveningPhoneNumber",customerContactDetails.getEveningPhoneNumber());
            mongoOperations.updateFirst(query, update, Customer.class);
        } catch (Exception e) {
            LOG.error("Repository layer:Processing Create Customer Contact Information ");
            throw new Exception("Repository layer:Processing Create Customer Contact Information errormessage{} " + e.getMessage());
        }
        return true;
    }

    public boolean updateCustomerContact(long customerId, CustomerContactDetails customerContactDetails) throws Exception {
        try {
            LOG.info("Repository layer:Processing Create Customer Contact Information ");
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(customerId));
            query.fields().include("_id");

            Update update = new Update();
            update.set("customerContactDetails.mobilePhoneNumber",customerContactDetails.getMobilePhoneNumber());
            update.set("customerContactDetails.daytimePhoneNumber",customerContactDetails.getDaytimePhoneNumber());
            update.set("customerContactDetails.eveningPhoneNumber",customerContactDetails.getEveningPhoneNumber());
            mongoOperations.updateFirst(query, update, Customer.class);
        } catch (Exception e) {
            LOG.error("Repository layer:Processing Create Customer Contact Information ");
            throw new Exception("Repository layer:Processing Create Customer Contact Information errormessage{} " + e.getMessage());
        }
        return true;
    }
}
