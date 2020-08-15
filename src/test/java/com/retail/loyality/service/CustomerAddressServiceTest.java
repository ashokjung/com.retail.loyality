package com.retail.loyality.service;

import com.retail.loyality.config.RestMessages;
import com.retail.loyality.exception.CustomerAddressException;
import com.retail.loyality.models.CustomerAddress;
import com.retail.loyality.repository.CustomerAddressDaoRepository;
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
public class CustomerAddressServiceTest {

    CustomerAddress customerAddress;
    boolean status;
    long customerId;
    CustomerResponse customerResponse;
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

        customerResponse = new CustomerResponse();
    }

    @Test
    public void addCustomerAddressService() throws CustomerAddressException {

        doNothing().when(customerAddressDaoRepository).addCustomerAddress(Mockito.anyLong(), Mockito.any());
        customerResponse = customerAddressService.addCustomerAddress(Mockito.anyLong(), Mockito.any());
        Assert.assertEquals(RestMessages.success, customerResponse.getStatus());
        Assert.assertEquals(RestMessages.addCustomerAddressSuccess, customerResponse.getMessage());
        Assert.assertNotNull(customerResponse);
    }


    @Test
    public void updateCustomerAddressService() throws CustomerAddressException {
        doNothing().when(customerAddressDaoRepository).addCustomerAddress(Mockito.anyLong(), Mockito.any());
        customerResponse = customerAddressService.updateCustomerAddress(Mockito.anyLong(), Mockito.any());
        Assert.assertEquals(RestMessages.success, customerResponse.getStatus());
        Assert.assertEquals(RestMessages.updateCustomerAddressSuccess, customerResponse.getMessage());
        Assert.assertNotNull(customerResponse);
    }

    @Test
    public void addCustomerAddressServiceExceptionTest() throws CustomerAddressException {

        doThrow(new CustomerAddressException(RestMessages.invalidCustomer)).when(customerAddressDaoRepository).addCustomerAddress(Mockito.anyLong(), Mockito.any());
        Throwable thrown = catchThrowable(() ->
                customerAddressService.addCustomerAddress(Mockito.anyLong(), Mockito.any())
        );
        Assertions.assertThat(thrown)
                .isInstanceOf(CustomerAddressException.class);
    }


    @Test
    public void updateCustomerAddressServiceExceptionTest() throws CustomerAddressException {
        doThrow(new CustomerAddressException(RestMessages.invalidCustomer)).when(customerAddressDaoRepository).updateCustomerAddress(Mockito.anyLong(), Mockito.any());
        Throwable thrown = catchThrowable(() ->
                customerAddressService.updateCustomerAddress(Mockito.anyLong(), Mockito.any())
        );
        Assertions.assertThat(thrown)
                .isInstanceOf(CustomerAddressException.class);
    }
}
