package com.retail.loyality.service;

import com.retail.loyality.enums.Gender;
import com.retail.loyality.exception.CustomerException;
import com.retail.loyality.models.Customer;
import com.retail.loyality.models.CustomerAddress;
import com.retail.loyality.models.CustomerContactDetails;
import com.retail.loyality.repository.CustomerDaoRepository;
import com.retail.loyality.response.CustomerResponse;
import org.assertj.core.api.Assertions;
import org.junit.*;
import org.junit.rules.ExpectedException;
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
    Customer customerwithnodata;
    CustomerAddress customerAddress;
    CustomerContactDetails customerContactDetails;
    Date date;
    long customerId;
    boolean status;
    CustomerResponse customerResponse;
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

        customerResponse = new CustomerResponse();
        customerResponse.setErrormessage("Error");
        customerResponse.setStatus(Boolean.TRUE);
        customerResponse.setMessage("success");

    }
    /*
    @Ignore
    @Test
    public void addCustomerServiceTest() throws CustomerException {

        doNothing().when(customerDaoRepository.createCustomer(Mockito.any()));
        when(customerDaoRepository.createCustomer(Mockito.any())).thenReturn();
        customerService.createCustomer(Mockito.any());
        Assert.assertEquals(true, customerService.createCustomer(Mockito.any()));
    }
    @Ignore
    @Test
    public void updateCustomerServiceTest() throws CustomerException {
        when(customerDaoRepository.updateCustomer(Mockito.anyLong(), Mockito.any())).thenReturn(true);
        status = customerService.updateCustomer(Mockito.anyLong(), Mockito.any());
        Assert.assertEquals(true, customerService.createCustomer(Mockito.any()));

    }
    @Ignore
    @Test
    public void addCustomerServiceTestWithException() throws CustomerException {

        when(customerDaoRepository.createCustomer(Mockito.any())).thenThrow(new CustomerException("Invalid Customer"));
        Throwable thrown = catchThrowable(() -> customerService.createCustomer(Mockito.any()));
        Assertions.assertThat(thrown).isInstanceOf(CustomerException.class);

    }
    @Ignore
    @Test
    public void updateCustomerServiceTestWithException() throws CustomerException {

        when(customerDaoRepository.updateCustomer(Mockito.anyLong(),Mockito.any())).thenThrow(new CustomerException("Invalid Customer"));
        Throwable thrown = catchThrowable(() -> customerService.updateCustomer(Mockito.anyLong(),Mockito.any()));
        Assertions.assertThat(thrown).isInstanceOf(CustomerException.class);

    }

     */
}
