package com.retail.loyality.service;

import com.retail.loyality.exception.CustomerContactException;
import com.retail.loyality.models.CustomerContactDetails;
import com.retail.loyality.repository.CustomerContactDaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerContactServiceImpl implements CustomerContactService {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerContactServiceImpl.class);
    @Autowired
    private CustomerContactDaoRepository customerContactDaoRepository;

    public boolean addCustomerContact(long customerId, CustomerContactDetails customerContactDetails) throws CustomerContactException {

        try {
            LOG.info("Service Layer:Processing Create Customer Contact Information ");
            customerContactDaoRepository.addCustomerContact(customerId,customerContactDetails);

        } catch (CustomerContactException e) {
            LOG.error("Service Layer:Processing Create Customer Contact Information ");
            throw new CustomerContactException("Service Layer:Processing Create Customer Contact Information errormessage{} " + e.getMessage());
        }
        return true;
    }

    public boolean updateCustomerContact(long customerId, CustomerContactDetails customerContactDetails) throws CustomerContactException {
        try {
            LOG.info("Service Layer:Processing Create Customer Contact Information ");
            customerContactDaoRepository.updateCustomerContact(customerId, customerContactDetails);

        } catch (CustomerContactException e) {
            LOG.error("Service Layer:Processing Create Customer Contact Information ");
            throw new CustomerContactException("Service Layer:Processing Create Customer Contact Information errormessage{} " + e.getMessage());

        }
        return true;
    }
}
