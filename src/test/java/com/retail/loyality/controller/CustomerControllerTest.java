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

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class CustomerControllerTest {

    Customer customer;
    CustomerAddress customerAddress;
    CustomerContactDetails customerContactDetails;
    Date date;
    ObjectMapper mapper;
    long customerId;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CustomerAddressService customerAddressService;
    @MockBean
    private CustomerContactService customerContactService;
    @MockBean
    private CustomerService customerService;

    @Before
    public void setup() {
        date = new Date();
        mapper = new ObjectMapper();
        customerId = 123456789l;
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
    public void addCustomer() throws Exception {
        when(customerService.createCustomer(customer)).thenReturn(true);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Endpoints.addCustomer)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(customer));


        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        verify(customerService).createCustomer(any(Customer.class));
        assertThat(result.getResponse().getContentLength()).isNotNull();
    }

    @Test
    public void updateCustomer() throws Exception {
        when(customerService.updateCustomer(customerId, customer)).thenReturn(Boolean.TRUE);

        this.mockMvc.perform(put("/api/v1/customer/{customerId}", customer.getCustomerId())
                .contentType("application/json")
                .content(mapper.writeValueAsString(customer)))
                .andExpect(status().isOk());
    }

    private String getCustomerIdJson(long customerId) {
        return "{\"id\":\"" + customerId + "\"}";
    }

    @Test
    public void updateCustomerAddressTest() throws Exception {
        when(customerAddressService.updateCustomerAddress(customerId, customerAddress)).thenReturn(Boolean.TRUE);

        this.mockMvc.perform(put("/api/v1/customer/address/{customerId}", customer.getCustomerId())
                .contentType("application/json")
                .content(mapper.writeValueAsString(customerAddress)))
                .andExpect(status().isOk());
    }

    @Test
    public void updateCustomerContactTest() throws Exception {
        when(customerContactService.updateCustomerContact(customerId, customerContactDetails)).thenReturn(Boolean.TRUE);

        this.mockMvc.perform(put("/api/v1/customer/contact/{customerId}", customer.getCustomerId())
                .contentType("application/json")
                .content(mapper.writeValueAsString(customerContactDetails)))
                .andExpect(status().isOk());
    }

}
