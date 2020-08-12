package com.retail.loyality.service;

import com.retail.loyality.models.CustomerAddress;
import com.retail.loyality.repository.CustomerAddressDaoRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerAddressServiceTest {

    CustomerAddress customerAddress;
    boolean status;
    long customerId;
    @Mock
    private CustomerAddressDaoRepository customerAddressDaoRepository;
    @InjectMocks
    private CustomerAddressServiceImpl customerAddressService;

    @Before
    public void setup() {
        customerId = 123l;
        status = Boolean.TRUE;
        customerAddress = new CustomerAddress();
        customerAddress.setAddressLine1("AddressLine1");
        customerAddress.setAddressLine2("AddressLine2");
        customerAddress.setAddressLine3("AddressLine3");
        customerAddress.setPostalCode("560064");
        customerAddress.setState("Karnataka");
        customerAddress.setCountry("India");
    }

    @Test
    public void addCustomerAddressService() throws Exception {

        when(customerAddressDaoRepository.addCustomerAddress(customerId, customerAddress)).thenReturn(true);
        status = customerAddressService.addCustomerAddress(customerId, customerAddress);
        Assert.assertEquals(true, customerAddressService.addCustomerAddress(customerId, customerAddress));
    }


    @Test
    public void updateCustomerAddressService() throws Exception {
        when(customerAddressDaoRepository.updateCustomerAddress(customerId, customerAddress)).thenReturn(true);
        status = customerAddressService.updateCustomerAddress(customerId, customerAddress);
        Assert.assertEquals(true, customerAddressService.updateCustomerAddress(customerId, customerAddress));
    }
}
