package com.retail.loyality.repository;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.junit4.SpringRunner;

import com.retail.loyality.exception.CustomerAddressException;
import com.retail.loyality.models.CustomerAddress;
@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerAddressRepositoryTest {
    CustomerAddress customerAddress;
    long customerId;

    @Mock
    private MongoOperations mongoOperations;

    @Autowired
    private CustomerAddressDaoRepository customerAddressDaoRepository;

    @Before
    public void setup()
    {
        customerId=123l;
        customerAddress = new CustomerAddress();
        customerAddress.setAddressLine1("AddressLine1");
        customerAddress.setAddressLine2("AddressLine2");
        customerAddress.setAddressLine3("AddressLine3");
        customerAddress.setPostalCode("560064");
        customerAddress.setState("Karnataka");
        customerAddress.setCountry("India");
    }


    @Test
    public void addCustomerAddressTest() throws CustomerAddressException {
        when(mongoOperations.findAndModify(Mockito.any(),Mockito.any(), Mockito.any())).thenReturn(true);
        customerAddressDaoRepository.addCustomerAddress(customerId,customerAddress);
    }

    @Test
    public void addCustomerAddresTestWithException() throws CustomerAddressException {

        when(mongoOperations.findAndModify(Mockito.any(), Mockito.any(),Mockito.any())).thenReturn(true);
        Throwable thrown = catchThrowable(() ->
                customerAddressDaoRepository.addCustomerAddress(customerId,null)
        );
        Assertions.assertThat(thrown)
                .isInstanceOf(CustomerAddressException.class);
    }


    @Test
    public void updateCustomerAddressTest() throws CustomerAddressException {
        when(mongoOperations.findAndModify(Mockito.any(), Mockito.any(),Mockito.any())).thenReturn(true);
        customerAddressDaoRepository.updateCustomerAddress(customerId,customerAddress);
    }

    @Test
    public void updateCustomerAddressTestWithException() throws CustomerAddressException {


        when(mongoOperations.findAndModify(Mockito.any(), Mockito.any(),Mockito.any())).thenReturn(true);
        Throwable thrown = catchThrowable(() ->
                customerAddressDaoRepository.updateCustomerAddress(customerId,null)
        );
        Assertions.assertThat(thrown)
                .isInstanceOf(CustomerAddressException.class);
    }



}
