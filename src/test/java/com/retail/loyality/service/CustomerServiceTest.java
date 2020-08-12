package com.retail.loyality.service;

import com.retail.loyality.enums.Gender;
import com.retail.loyality.models.Customer;
import com.retail.loyality.models.CustomerAddress;
import com.retail.loyality.models.CustomerContactDetails;
import com.retail.loyality.repository.CustomerDaoRepository;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerServiceTest {

    Customer customer;
    Customer customerwithnodata;
    CustomerAddress customerAddress;
    CustomerContactDetails customerContactDetails;
    Date date;
    long customerId;
    boolean status;
    @Mock
    private CustomerDaoRepository customerDaoRepository;
    @InjectMocks
    private CustomerServiceImpl customerService;

    @Before
    public void setup() {
        customerId = 123l;
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
        customer.setCustomerId(123l);
        customer.setDateOfbirth(date);
        customer.setGender(Gender.MALE);
        customer.setFirstName("FirtName");
        customer.setLastName("LastName");
        customer.setCustomerAddress(customerAddress);
        customer.setCustomerContactDetails(customerContactDetails);
        customerwithnodata = new Customer();

    }

    @Test
    public void addCustomerServiceTest() throws Exception {

        when(customerDaoRepository.createCustomer(Mockito.any())).thenReturn(true);
        status = customerService.createCustomer(Mockito.any());
        Assert.assertEquals(true, customerService.createCustomer(Mockito.any()));
    }

    @Test
    public void updateCustomerServiceTest() throws Exception {
        when(customerDaoRepository.updateCustomer(Mockito.anyLong(), Mockito.any())).thenReturn(true);
        status = customerService.updateCustomer(Mockito.anyLong(), Mockito.any());
        Assert.assertEquals(true, customerService.createCustomer(Mockito.any()));

    }

    @Test
    public void addCustomerServiceTestWithException() throws Exception {

        when(customerDaoRepository.createCustomer(Mockito.any())).thenThrow(new Exception("Invalid Customer"));
        Throwable thrown = catchThrowable(() -> customerService.createCustomer(Mockito.any()));
        Assertions.assertThat(thrown).isInstanceOf(Exception.class);

    }

    @Test
    public void updateCustomerServiceTestWithException() throws Exception {

        when(customerDaoRepository.updateCustomer(Mockito.anyLong(),Mockito.any())).thenThrow(new Exception("Invalid Customer"));
        Throwable thrown = catchThrowable(() -> customerService.updateCustomer(Mockito.anyLong(),Mockito.any()));
        Assertions.assertThat(thrown).isInstanceOf(Exception.class);

    }
}
