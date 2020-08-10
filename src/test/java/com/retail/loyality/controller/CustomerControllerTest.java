package com.retail.loyality.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.loyality.config.Endpoints;
import com.retail.loyality.enums.Gender;
import com.retail.loyality.models.Customer;
import com.retail.loyality.models.CustomerAddress;
import com.retail.loyality.models.CustomerContactDetails;
import com.retail.loyality.service.CustomerAddressService;
import com.retail.loyality.service.CustomerContactService;
import com.retail.loyality.service.CustomerService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatcher.*;
import static org.mockito.Mockito.*;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerAddressService customerAddressService;

    @MockBean
    private CustomerContactService customerContactService;

    @MockBean
    private CustomerService customerService;

    Customer customer;
    CustomerAddress customerAddress;
    CustomerContactDetails customerContactDetails;
    Date date;
    ObjectMapper mapper;
    @Before
    public void  setup(){
        date= new Date();
        mapper = new ObjectMapper();
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
    @Test
    public void addCustomer () throws Exception
    {
        when(customerService.createCustomer(customer)).thenReturn(true);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Endpoints.addCustomer)
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .accept(MediaType.APPLICATION_JSON)
                                        .content(mapper.writeValueAsString(customer));


        MvcResult result =mockMvc.perform(requestBuilder).andReturn();
        verify(customerService).createCustomer(any(Customer.class));
        assertThat(result.getResponse().getContentLength()).isNotNull();
    }

    @Ignore
    @Test
    public void updateCustomer() throws Exception{
        long customerId=123456789l;

        RequestBuilder requestBuilder;
        requestBuilder = MockMvcRequestBuilders.put(Endpoints.updateCustomer+customerId)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(mapper.writeValueAsString(customer))
                .content(getCustomerIdJson(123456789l));


        MvcResult result =mockMvc.perform(requestBuilder).andReturn();
        verify(customerService).updateCustomer((Long) any(),any(Customer.class));
        assertThat(result.getResponse().getContentLength()).isNotNull();
    }

    private String getCustomerIdJson(long customerId) {
        return "{\"id\":\"" + customerId + "\"}";
    }
}
