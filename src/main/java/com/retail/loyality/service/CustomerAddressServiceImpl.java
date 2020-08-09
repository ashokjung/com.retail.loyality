package com.retail.loyality.service;

import com.retail.loyality.models.CustomerAddress;
import org.springframework.stereotype.Service;

@Service
public class CustomerAddressServiceImpl  implements  CustomerAddressService{
    public boolean addCustomerAddress(long CustomerId,CustomerAddress customerAddress) {
        return true;
    }

    public boolean updateCustomerAddress(long CustomerId,CustomerAddress customerAddress) {
        return true;
    }
}
