package com.retail.loyality.service;

import com.retail.loyality.exception.CustomerAddressException;
import com.retail.loyality.models.CustomerAddress;
import com.retail.loyality.repository.CustomerAddressDaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerAddressServiceImpl implements CustomerAddressService {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerAddressServiceImpl.class);
    @Autowired
    private CustomerAddressDaoRepository customerAddressDaoRepository;
    public boolean addCustomerAddress(long customerId, CustomerAddress customerAddress) throws CustomerAddressException {
        try {
            LOG.info("Service Layer:Processing adding Customer Contact Information ");
            customerAddressDaoRepository.addCustomerAddress(customerId,customerAddress);

        } catch (CustomerAddressException e) {
            LOG.error("Service Layer:Processing adding Customer Contact Information ");
            throw new CustomerAddressException("Service Layer:Processing adding Customer Contact Information errormessage{} " + e.getMessage());
        }
        return true;
    }

    public boolean updateCustomerAddress(long customerId, CustomerAddress customerAddress) throws CustomerAddressException {
        try {
            LOG.info("Service Layer:Processing adding Customer Contact Information ");
            customerAddressDaoRepository.updateCustomerAddress(customerId,customerAddress);

        } catch (CustomerAddressException e) {
            LOG.error("Service Layer:Processing adding Customer Contact Information  ");
            throw new CustomerAddressException("Service Layer:Processing adding Customer Contact Information errormessage{} " + e.getMessage());
        }
        return true;
    }
}
