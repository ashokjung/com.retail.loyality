package com.retail.loyality.repository;

import com.retail.loyality.exception.CustomerAddressException;
import com.retail.loyality.exception.CustomerException;
import com.retail.loyality.models.CustomerAddress;
import com.retail.loyality.enums.Gender;
import com.retail.loyality.models.Customer;
import com.retail.loyality.models.CustomerAddress;
import com.retail.loyality.models.CustomerContactDetails;
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

import java.util.Date;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;
@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerRepositoryTest {

    Customer customer;
    CustomerAddress customerAddress;
    CustomerContactDetails customerContactDetails;
    Date date;
    long customerId;
    boolean status;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private MongoOperations mongoOperations;

    @Autowired
    private CustomerDaoRepository customerDaoRepository;

    @Before
    public void setup()
    {
        customerId=123l;
        date= new Date();
        status = Boolean.TRUE;
        customerAddress = new CustomerAddress();
        customerAddress.setAddressLine1("AddressLine1");
        customerAddress.setAddressLine2("AddressLine2");
        customerAddress.setAddressLine3("AddressLine3");
        customerAddress.setPostalCode("560064");
        customerAddress.setState("Karnataka");
        customerAddress.setCountry("India");

        customerContactDetails = new CustomerContactDetails();
        customerContactDetails.setEveningPhoneNumber("+918095713751");
        customerContactDetails.setDaytimePhoneNumber("+918095713751");
        customerContactDetails.setMobilePhoneNumber("+918095713751");

        customer = new Customer();
        customer.setAge(30);
        customer.setCustomerId(123l);
        customer.setDateOfbirth(date);
        customer.setGender(Gender.MALE);
        customer.setFirstName("FirtName");
        customer.setLastName("LastName");
        customer.setCustomerAddress(customerAddress);
        customer.setCustomerContactDetails(customerContactDetails);
    }
/*
    @Test
    public void addCustomerTest() throws CustomerException {
        when(customerRepository.save(Mockito.any())).thenReturn(true);

        Assert.assertTrue(customerDaoRepository.createCustomer(customer));
    }

    @Test
    public void addCustomerTestWithException() throws CustomerException {

        when(customerRepository.save(Mockito.any())).thenReturn(true);
        Throwable thrown = catchThrowable(() ->
                customerDaoRepository.createCustomer(null)
        );
        Assertions.assertThat(thrown)
                .isInstanceOf(CustomerException.class);

    }

    @Test
    public void updateCustomerTest() throws CustomerException {
        when(mongoOperations.findAndReplace(Mockito.any(), Mockito.any())).thenReturn(true);

        Assert.assertTrue(customerDaoRepository.updateCustomer(customerId,customer));
    }

    @Test
    public void updateCustomerTestWithException() throws CustomerException {

        when(mongoOperations.findAndReplace(Mockito.any(), Mockito.any())).thenReturn(true);
        Throwable thrown = catchThrowable(() ->
                customerDaoRepository.updateCustomer(customerId,null)
        );
        Assertions.assertThat(thrown)
                .isInstanceOf(CustomerException.class);

    }


 */
}
