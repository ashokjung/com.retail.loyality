package com.retail.loyality.service;

import com.retail.loyality.config.RestMessages;
import com.retail.loyality.exception.CustomerContactException;
import com.retail.loyality.models.CustomerContactDetails;
import com.retail.loyality.repository.CustomerContactDaoRepository;
import com.retail.loyality.response.CustomerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerContactServiceImpl implements CustomerContactService {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerContactServiceImpl.class);
    @Autowired
    private CustomerContactDaoRepository customerContactDaoRepository;

    public CustomerResponse addCustomerContact(long customerId, CustomerContactDetails customerContactDetails) throws CustomerContactException {
        CustomerResponse customerResponse = new CustomerResponse();
        try {
            LOG.info("Service Layer:Processing Create Customer Contact Information ");
            customerContactDaoRepository.addCustomerContact(customerId, customerContactDetails);
            customerResponse.setMessage(RestMessages.addCustomerContactSuccess);
            customerResponse.setStatus(RestMessages.success);
        } catch (CustomerContactException e) {
            LOG.error("Service Layer:Processing Create Customer Contact Information ");
            throw new CustomerContactException("Service Layer:Processing Create Customer Contact Information errormessage{} " + e.getMessage());
        }
        return customerResponse;
    }

    public CustomerResponse updateCustomerContact(long customerId, CustomerContactDetails customerContactDetails) throws CustomerContactException {
        CustomerResponse customerResponse = new CustomerResponse();
        try {
            LOG.info("Service Layer:Processing Create Customer Contact Information ");
            customerContactDaoRepository.updateCustomerContact(customerId, customerContactDetails);
            customerResponse.setMessage(RestMessages.updateCustomerContactSuccess);
            customerResponse.setStatus(RestMessages.success);
        } catch (CustomerContactException e) {
            LOG.error("Service Layer:Processing Create Customer Contact Information ");
            throw new CustomerContactException("Service Layer:Processing Create Customer Contact Information errormessage{} " + e.getMessage());
        }
        return customerResponse;
    }
}
