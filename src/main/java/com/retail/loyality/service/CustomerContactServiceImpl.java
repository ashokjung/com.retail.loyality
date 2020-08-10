package com.retail.loyality.service;

import com.retail.loyality.models.CustomerContactDetails;
import org.springframework.stereotype.Service;

@Service
public class CustomerContactServiceImpl implements CustomerContactService {
    public boolean addCustomerContact(long customerId, CustomerContactDetails customerContactDetails) {
        return true;
    }

    public boolean updateCustomerContact(long customerId, CustomerContactDetails customerContactDetails) {
        return true;
    }
}
