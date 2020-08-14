package com.retail.loyality.repository;

import com.retail.loyality.exception.CustomerContactException;
import com.retail.loyality.models.CustomerContactDetails;

public interface CustomerContactDaoRepository {
    boolean addCustomerContact(long customerId, CustomerContactDetails customerContactDetails) throws CustomerContactException;

    boolean updateCustomerContact(long customerId, CustomerContactDetails customerContactDetails) throws CustomerContactException;
}
