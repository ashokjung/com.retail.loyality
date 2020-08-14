package com.retail.loyality.repository;

import com.retail.loyality.models.CustomerAddress;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;
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
    public void addCustomerAddressTest() throws Exception {
        when(mongoOperations.findAndModify(Mockito.any(),Mockito.any(), Mockito.any())).thenReturn(true);

            Assert.assertTrue(customerAddressDaoRepository.addCustomerAddress(customerId,customerAddress));
    }

    @Test
    public void addCustomerAddresTestWithException() throws Exception {

        when(mongoOperations.findAndModify(Mockito.any(), Mockito.any(),Mockito.any())).thenReturn(true);
        Throwable thrown = catchThrowable(() ->
                customerAddressDaoRepository.addCustomerAddress(customerId,null)
        );
        Assertions.assertThat(thrown)
                .isInstanceOf(Exception.class);

    }

    @Test
    public void updateCustomerAddressTest() throws Exception {
        when(mongoOperations.findAndModify(Mockito.any(), Mockito.any(),Mockito.any())).thenReturn(true);

        Assert.assertTrue(customerAddressDaoRepository.updateCustomerAddress(customerId,customerAddress));
    }

    @Test
    public void updateCustomerAddressTestWithException() throws Exception {

        when(mongoOperations.findAndModify(Mockito.any(), Mockito.any(),Mockito.any())).thenReturn(true);
        Throwable thrown = catchThrowable(() ->
                customerAddressDaoRepository.updateCustomerAddress(customerId,null)
        );
        Assertions.assertThat(thrown)
                .isInstanceOf(Exception.class);

    }



}
