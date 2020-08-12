package com.retail.loyality.service;

import com.retail.loyality.models.CustomerContactDetails;
import com.retail.loyality.repository.CustomerContactDaoRepository;
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
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerContactServiceTest {

    CustomerContactDetails customerContactDetails;
    long customerId;
    boolean status;
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
    }

    @Test
    public void addCustomerContactService() throws Exception {
        when(customerContactDaoRepository.addCustomerContact(customerId, customerContactDetails)).thenReturn(true);
        status = customerContactService.addCustomerContact(customerId, customerContactDetails);
        Assert.assertEquals(true, customerContactService.addCustomerContact(customerId, customerContactDetails));
    }

    @Test
    public void updateCustomerContactService() throws Exception {
        when(customerContactDaoRepository.updateCustomerContact(customerId, customerContactDetails)).thenReturn(true);
        status = customerContactService.updateCustomerContact(customerId, customerContactDetails);
        Assert.assertEquals(true, customerContactService.updateCustomerContact(customerId, customerContactDetails));
    }

    @Test
    public void addCustomerContactServiceExceptionTest() throws Exception {
        when(customerContactDaoRepository.addCustomerContact(Mockito.anyLong(),Mockito.any())).thenThrow(new Exception("Invalid Customer"));
        Throwable thrown = catchThrowable(() -> customerContactService.addCustomerContact(Mockito.anyLong(),Mockito.any()));
        Assertions.assertThat(thrown).isInstanceOf(Exception.class);
    }

    @Test
    public void updateCustomerContactServiceExceptionTest() throws Exception {
        when(customerContactDaoRepository.updateCustomerContact(Mockito.anyLong(),Mockito.any())).thenThrow(new Exception("Invalid Customer"));
        Throwable thrown = catchThrowable(() -> customerContactService.updateCustomerContact(Mockito.anyLong(),Mockito.any()));
        Assertions.assertThat(thrown).isInstanceOf(Exception.class);
    }


}
