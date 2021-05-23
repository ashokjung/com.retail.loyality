package com.retail.loyality.service;

import com.retail.loyality.config.RestMessages;
import com.retail.loyality.exception.CustomerAddressException;
import com.retail.loyality.models.CustomerAddress;
import com.retail.loyality.repository.CustomerAddressDaoRepository;
import com.retail.loyality.response.CustomerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerAddressServiceImpl implements CustomerAddressService {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerAddressServiceImpl.class);
    @Autowired
    private CustomerAddressDaoRepository customerAddressDaoRepository;

    public CustomerResponse addCustomerAddress(long customerId, CustomerAddress customerAddress)
            throws CustomerAddressException {
        CustomerResponse customerResponse = new CustomerResponse();
        try {
            LOG.info("Service Layer:Processing adding Customer Contact Information ");
            customerAddressDaoRepository.addCustomerAddress(customerId, customerAddress);
            customerResponse.setMessage(RestMessages.addCustomerAddressSuccess);
            customerResponse.setStatus(RestMessages.success);
        } catch (CustomerAddressException e) {
            LOG.error("Service Layer:Processing adding Customer Contact Information ");
            throw new CustomerAddressException("Service Layer:Processing adding " +
                    "Customer Contact Information errormessage{} "
                    + e.getMessage());
        }
        return customerResponse;
    }

    public CustomerResponse updateCustomerAddress(long customerId, CustomerAddress customerAddress)
            throws CustomerAddressException {
        CustomerResponse customerResponse = new CustomerResponse();
        try {
            LOG.info("Service Layer:Processing adding Customer Contact Information ");
            customerAddressDaoRepository.updateCustomerAddress(customerId, customerAddress);
            customerResponse.setMessage(RestMessages.updateCustomerAddressSuccess);
            customerResponse.setStatus(RestMessages.success);
        } catch (CustomerAddressException e) {
            LOG.error("Service Layer:Processing adding Customer Contact Information  ");
            throw new CustomerAddressException("Service Layer:Processing adding Customer " +
                    "Contact Information errormessage{} "
                    + e.getMessage());
        }
        return customerResponse;
    }
}
