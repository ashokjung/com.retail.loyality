package com.retail.loyality.repository;

import com.retail.loyality.models.CustomerContactDetails;

public interface CustomerContactDaoRepository {
    boolean addCustomerContact(long customerId, CustomerContactDetails customerContactDetails) throws Exception;

    boolean updateCustomerContact(long customerId, CustomerContactDetails customerContactDetails) throws Exception;
}
