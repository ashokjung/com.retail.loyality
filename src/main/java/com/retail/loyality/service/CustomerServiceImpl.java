package com.retail.loyality.service;

import com.retail.loyality.models.Customer;
import com.retail.loyality.repository.CustomerDaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerServiceImpl.class);


    @Autowired
    private CustomerDaoRepository customerDaoRepository;


    public boolean createCustomer(Customer customer) throws Exception {
        try {
            LOG.info("Service Layer:Processing Create Customer Information ");
            customerDaoRepository.createCustomer(customer);
        } catch (Exception e) {
            LOG.error("Service Layer:Error while Processing  Create Customer Information ");
            throw new Exception("Service Layer: Error while processing errormessage{} " + e.getMessage());
        }
        return true;
    }

    public boolean updateCustomer(long customerId, Customer customer) throws Exception {
        try {
            LOG.info("Service Layer:Processing Create Customer Information ");
            customerDaoRepository.updateCustomer(customerId, customer);
        } catch (Exception e) {
            LOG.error("Service Layer:Error while Processing  Create Customer Information ");
            throw new Exception("Service Layer: Error while processing errormessage{} " + e.getMessage());
        }
        return true;
    }
}
