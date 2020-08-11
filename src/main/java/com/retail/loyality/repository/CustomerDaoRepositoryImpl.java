package com.retail.loyality.repository;

import com.retail.loyality.models.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoRepositoryImpl implements CustomerDaoRepository {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerDaoRepositoryImpl.class);
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MongoOperations mongoOperations;


    public boolean createCustomer(Customer customer) throws Exception {
        try {
            LOG.info("Repository layer: Processing Create Customer Information ");
            customerRepository.save(customer);

        } catch (Exception e) {
            LOG.error("Repository layer: Error while Processing  Create Customer Information ");
            throw new Exception("" + e.getMessage());
        }
        return true;
    }

    public boolean updateCustomer(long customerId, Customer customer) throws Exception {
        try {
            LOG.info("Repository layer: Processing Create Customer Information ");
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(customerId));
            query.fields().include("_id");

            Customer customerRepo = mongoOperations.findAndReplace(query, customer);
        }
        catch (Exception e)
        {
            LOG.error("Repository layer: Error while Processing  Updating Customer Information ");
            throw new Exception("Repository layer: Error while Processing  Updating Customer Information " + e.getMessage());
        }
        return true;
    }
}
