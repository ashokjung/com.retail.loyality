package com.retail.loyality.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.loyality.config.Endpoints;
import com.retail.loyality.enums.Gender;
import com.retail.loyality.models.Customer;
import com.retail.loyality.models.CustomerAddress;
import com.retail.loyality.models.CustomerContactDetails;
import com.retail.loyality.response.CustomerResponse;
import com.retail.loyality.security.request.JwtRequest;
import com.retail.loyality.service.CustomerAddressService;
import com.retail.loyality.service.CustomerContactService;
import com.retail.loyality.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
    JwtRequest userDetails;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CustomerAddressService customerAddressService;
    @MockBean
    private CustomerContactService customerContactService;
    @MockBean
    private CustomerService customerService;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private FilterChainProxy springSecurityFilterChain;
    @MockBean
    private AuthenticationManager authenticationManager;

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
        //customer.setCustomerId(123l);
        customer.setDateOfbirth(date);
        customer.setGender(Gender.MALE);
        customer.setFirstName("FirstName");
        customer.setLastName("LastName");
        customer.setCustomerAddress(customerAddress);
        customer.setCustomerContactDetails(customerContactDetails);

        userDetails = new JwtRequest();
        userDetails.setUsername("clubcardAdminUser");
        userDetails.setPassword("password");
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).addFilter(springSecurityFilterChain).build();
    }


    @Test
    public void addCustomer() throws Exception {


        String accessToken = obtainAccessToken(userDetails);
        when(customerService.createCustomer(customer)).thenReturn(new CustomerResponse());
        this.mockMvc.perform(post( Endpoints.addCustomer)
                .contentType("application/json")
                .header("Authorization", "Bearer " + accessToken)
                .content(mapper.writeValueAsString(customer)))
                .andExpect(status().isOk());
    }

    @Test
    public void updateCustomer() throws Exception {
        String accessToken = obtainAccessToken(userDetails);
        when(customerService.updateCustomer(customerId, customer)).thenReturn(new CustomerResponse());
        this.mockMvc.perform(put(Endpoints.updateCustomer, customerId)
                .contentType("application/json")
                .header("Authorization", "Bearer " + accessToken)
                .content(mapper.writeValueAsString(customer)))
                .andExpect(status().isOk());
    }

    @Test
    public void updateCustomerAddressTest() throws Exception {
        String accessToken = obtainAccessToken(userDetails);
        when(customerAddressService.addCustomerAddress(customerId, customerAddress)).thenReturn(new CustomerResponse());
        this.mockMvc.perform(put( Endpoints.updateCustomerAddress, customerId)
                .contentType("application/json")
                .header("Authorization", "Bearer " + accessToken)
                .content(mapper.writeValueAsString(customerAddress)))
                .andExpect(status().isOk());
    }


    @Test
    public void updateCustomerContactTest() throws Exception {
        String accessToken = obtainAccessToken(userDetails);
        when(customerContactService.addCustomerContact(customerId, customerContactDetails)).thenReturn(new CustomerResponse());
        this.mockMvc.perform(put(Endpoints.updateCustomerContactDetails, customerId)
                .contentType("application/json")
                .header("Authorization", "Bearer " + accessToken)
                .content(mapper.writeValueAsString(customerContactDetails)))
                .andExpect(status().isOk());
    }

    @Test
    public void updateCustomerContactDetailsTesForBadCrdentials() throws Exception {
        userDetails.setUsername("test");
        when(authenticationManager.authenticate(Mockito.any())).thenThrow(new BadCredentialsException("Bad Credentials"));
        this.mockMvc.perform(post("/authenticate")
                .contentType("application/json")
                .content(mapper.writeValueAsString(userDetails)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$.message", is("INVALID_CREDENTIALS")));
    }

    @Test
    public void updateCustomerContactDetailsTesForDisabledUser() throws Exception {
        userDetails.setUsername("test");
        when(authenticationManager.authenticate(Mockito.any())).thenThrow(new DisabledException("USER_DISABLED"));
        this.mockMvc.perform(post("/authenticate")
                .contentType("application/json")
                .content(mapper.writeValueAsString(userDetails)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$.message", is("USER_DISABLED")));
    }

    private String obtainAccessToken(JwtRequest userDetails) throws Exception {
        ResultActions result
                =
                this.mockMvc.perform(post("/authenticate")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(userDetails)))
                        .andExpect(status().isOk());

        String resultString = result.andReturn().getResponse().getContentAsString();

        JacksonJsonParser jsonParser = new JacksonJsonParser();
        return jsonParser.parseMap(resultString).get("token").toString();

    }

}
