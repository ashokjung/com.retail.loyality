package com.retail.loyality.service;

import com.retail.loyality.config.RestMessages;
import com.retail.loyality.enums.Gender;
import com.retail.loyality.exception.CustomerException;
import com.retail.loyality.models.Customer;
import com.retail.loyality.models.CustomerAddress;
import com.retail.loyality.models.CustomerContactDetails;
import com.retail.loyality.repository.CustomerDaoRepository;
import com.retail.loyality.response.CustomerResponse;
import com.retail.loyality.util.MongoSequenceGenerator;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerServiceTest {

    Customer customer;
    Customer customerWithNoData;
    CustomerAddress customerAddress;
    CustomerContactDetails customerContactDetails;
    Date date;
    long customerId;
    boolean status;
    CustomerResponse customerResponse;
    CustomerResponse customerResponseupdate;
    @Mock
    private CustomerDaoRepository customerDaoRepository;
    @InjectMocks
    private CustomerServiceImpl customerService;
    @Mock
    private MongoSequenceGenerator mongoSequenceGenerator;
    @Before
    public void setup() {
        customerId = 123L;
        date = new Date();
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
        //customer.setCustomerId(123L);
        customer.setDateOfbirth(date);
        customer.setGender(Gender.MALE);
        customer.setFirstName("FirstName");
        customer.setLastName("LastName");
        customer.setCustomerAddress(customerAddress);
        customer.setCustomerContactDetails(customerContactDetails);
        customerWithNoData = new Customer();

        customerResponse = new CustomerResponse();
        customerResponseupdate = new CustomerResponse();


    }

    @Test
    public void addCustomerServiceTest() throws CustomerException {

        doNothing().when(customerDaoRepository).createCustomer(Mockito.any());
        when(mongoSequenceGenerator.generateSequence(Mockito.any())).thenReturn(Mockito.anyLong());
        customerResponse =customerService.createCustomer(customer);
        Assert.assertNotNull(customerResponse);
        Assert.assertEquals(RestMessages.success,customerResponse.getStatus());
        Assert.assertEquals(RestMessages.createCustomerSuccess,customerResponse.getMessage());
    }

    @Test
    public void updateCustomerServiceTest() throws CustomerException {
        doNothing().when(customerDaoRepository).updateCustomer(Mockito.anyLong(), Mockito.any());
        customerResponse = customerService.updateCustomer(Mockito.anyLong(), Mockito.any());
        Assert.assertEquals(RestMessages.success, customerResponse.getStatus());
        Assert.assertEquals(RestMessages.updateCustomerSuccess, customerResponse.getMessage());
        Assert.assertNotNull(customerResponse);

    }

    @Test
    public void addCustomerServiceTestWithException() throws CustomerException {

        doThrow(new CustomerException(RestMessages.invalidCustomer)).when(customerDaoRepository).createCustomer(Mockito.any());
        Throwable thrown = catchThrowable(() ->
                customerService.createCustomer(customer)
        );
        Assertions.assertThat(thrown)
                .isInstanceOf(CustomerException.class);

    }

    @Test
    public void updateCustomerServiceTestWithException() throws CustomerException {

        doThrow(new CustomerException(RestMessages.invalidCustomer)).when(customerDaoRepository).updateCustomer(Mockito.anyLong(), Mockito.any());
        Throwable thrown = catchThrowable(() ->
                customerService.updateCustomer(customerId, customer)
        );
        Assertions.assertThat(thrown)
                .isInstanceOf(CustomerException.class);

    }


}
