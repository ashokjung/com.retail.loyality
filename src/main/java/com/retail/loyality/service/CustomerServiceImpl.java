package com.retail.loyality.service;

import com.retail.loyality.config.RestMessages;
import com.retail.loyality.exception.CustomerException;
import com.retail.loyality.models.Customer;
import com.retail.loyality.repository.CustomerDaoRepository;
import com.retail.loyality.response.CustomerResponse;
import com.retail.loyality.util.MongoSequenceGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {


    private static final Logger LOG = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerDaoRepository customerDaoRepository;
    @Autowired
    private MongoSequenceGenerator mongoSequenceGenerator;

    public CustomerResponse createCustomer(Customer customer) throws CustomerException {

        CustomerResponse customerResponse = new CustomerResponse();
        try {
            customer.setCustomerId(mongoSequenceGenerator.generateSequence(Customer.SEQUENCE_NAME));
            LOG.info("Service Layer:Processing Create Customer Information ");
            customerDaoRepository.createCustomer(customer);
            customerResponse.setStatus(RestMessages.success);
            customerResponse.setMessage(RestMessages.createCustomerSuccess);
        } catch (CustomerException e) {
            LOG.error("Service Layer:Error while Processing  Create Customer Information ");
            throw new CustomerException("Service Layer: Error while processing errormessage{} " + e.getMessage());
        }
        return customerResponse;
    }

    public CustomerResponse updateCustomer(long customerId, Customer customer) throws CustomerException {
        CustomerResponse customerResponse = new CustomerResponse();
        try {
            LOG.info("Service Layer:Processing Create Customer Information ");
            customerDaoRepository.updateCustomer(customerId, customer);
            customerResponse.setStatus(RestMessages.success);
            customerResponse.setMessage(RestMessages.updateCustomerSuccess);
        } catch (CustomerException e) {
            LOG.error("Service Layer:Error while Processing  Create Customer Information ");
            throw new CustomerException("Service Layer: Error while processing errormessage{} " + e.getMessage());
        }
        return customerResponse;
    }
}
