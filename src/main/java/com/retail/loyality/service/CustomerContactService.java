package com.retail.loyality.service;

import com.retail.loyality.models.CustomerContactDetails;

public interface CustomerContactService {

    boolean addCustomerContact(long CustomerId,CustomerContactDetails customerContactDetails);
    boolean updateCustomerContact(long CustomerId,CustomerContactDetails customerContactDetails);
}
