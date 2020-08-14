package com.retail.loyality.service;

import com.retail.loyality.exception.CustomerContactException;
import com.retail.loyality.models.CustomerContactDetails;

public interface CustomerContactService {

    boolean addCustomerContact(long customerId, CustomerContactDetails customerContactDetails) throws CustomerContactException;

    boolean updateCustomerContact(long customerId, CustomerContactDetails customerContactDetails) throws CustomerContactException;
}
