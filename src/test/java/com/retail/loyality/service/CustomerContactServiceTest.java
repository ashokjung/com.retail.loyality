package com.retail.loyality.service;

import com.retail.loyality.config.RestMessages;
import com.retail.loyality.exception.CustomerContactException;
import com.retail.loyality.models.CustomerContactDetails;
import com.retail.loyality.repository.CustomerContactDaoRepository;
import com.retail.loyality.response.CustomerResponse;
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

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerContactServiceTest {

    CustomerContactDetails customerContactDetails;
    long customerId;
    boolean status;
    CustomerResponse customerResponse;
    @Mock
    private CustomerContactDaoRepository customerContactDaoRepository;
    @InjectMocks
    private CustomerContactServiceImpl customerContactService;

    @Before
    public void setup() {
        customerId = 123l;
        status = Boolean.TRUE;
        customerContactDetails = new CustomerContactDetails();
        customerContactDetails.setEveningPhoneNumber("+918095713751");
        customerContactDetails.setDaytimePhoneNumber("+918095713751");
        customerContactDetails.setMobilePhoneNumber("+918095713751");
        customerResponse = new CustomerResponse();
    }

    @Test
    public void addCustomerContactService() throws CustomerContactException {

        doNothing().when(customerContactDaoRepository).addCustomerContact(Mockito.anyLong(), Mockito.any());
        customerResponse = customerContactService.addCustomerContact(Mockito.anyLong(), Mockito.any());
        Assert.assertEquals(RestMessages.success, customerResponse.getStatus());
        Assert.assertEquals(RestMessages.addCustomerContactSuccess, customerResponse.getMessage());
        Assert.assertNotNull(customerResponse);
    }

    @Test
    public void updateCustomerContactService() throws CustomerContactException {
        doNothing().when(customerContactDaoRepository).updateCustomerContact(Mockito.anyLong(), Mockito.any());
        customerResponse = customerContactService.updateCustomerContact(Mockito.anyLong(), Mockito.any());
        Assert.assertEquals(RestMessages.success, customerResponse.getStatus());
        Assert.assertEquals(RestMessages.updateCustomerContactSuccess, customerResponse.getMessage());
        Assert.assertNotNull(customerResponse);
    }

    @Test
    public void addCustomerContactServiceExceptionTest() throws CustomerContactException {

        doThrow(new CustomerContactException(RestMessages.invalidCustomer)).when(customerContactDaoRepository).addCustomerContact(Mockito.anyLong(), Mockito.any());
        Throwable thrown = catchThrowable(() ->
                customerContactService.addCustomerContact(Mockito.anyLong(), Mockito.any())
        );
        Assertions.assertThat(thrown)
                .isInstanceOf(CustomerContactException.class);

    }

    @Test
    public void updateCustomerContactServiceExceptionTest() throws CustomerContactException {
        doThrow(new CustomerContactException(RestMessages.invalidCustomer)).when(customerContactDaoRepository).updateCustomerContact(Mockito.anyLong(), Mockito.any());
        Throwable thrown = catchThrowable(() ->
                customerContactService.updateCustomerContact(Mockito.anyLong(), Mockito.any())
        );
        Assertions.assertThat(thrown)
                .isInstanceOf(CustomerContactException.class);
    }


}
