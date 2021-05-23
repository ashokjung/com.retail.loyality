package com.retail.loyality.repository;

import com.retail.loyality.exception.CustomerContactException;
import com.retail.loyality.models.CustomerContactDetails;

public interface CustomerContactDaoRepository {
    void addCustomerContact(long customerId, CustomerContactDetails customerContactDetails)
            throws CustomerContactException;

    void updateCustomerContact(long customerId, CustomerContactDetails customerContactDetails)
            throws CustomerContactException;
}
