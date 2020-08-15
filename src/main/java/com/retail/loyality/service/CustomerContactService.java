package com.retail.loyality.service;

import com.retail.loyality.exception.CustomerContactException;
import com.retail.loyality.models.CustomerContactDetails;
import com.retail.loyality.response.CustomerResponse;

public interface CustomerContactService {

    CustomerResponse addCustomerContact(long customerId, CustomerContactDetails customerContactDetails) throws CustomerContactException;

    CustomerResponse updateCustomerContact(long customerId, CustomerContactDetails customerContactDetails) throws CustomerContactException;
}
