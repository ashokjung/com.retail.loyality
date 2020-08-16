package com.retail.loyality.controller;

import com.retail.loyality.config.Endpoints;
import com.retail.loyality.exception.CustomerAddressException;
import com.retail.loyality.exception.CustomerContactException;
import com.retail.loyality.exception.CustomerException;
import com.retail.loyality.models.Customer;
import com.retail.loyality.models.CustomerAddress;
import com.retail.loyality.models.CustomerContactDetails;
import com.retail.loyality.response.CustomerResponse;
import com.retail.loyality.service.CustomerAddressService;
import com.retail.loyality.service.CustomerContactService;
import com.retail.loyality.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "", hidden = true, tags = {"Customer"})
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerAddressService customerAddressService;
    @Autowired
    private CustomerContactService customerContactService;

    @ApiOperation(nickname = "Add Customer", value = "Add new Customer", notes = "Add new Customer", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Customer"}, authorizations = {@Authorization(value = "jwtToken")})
    @RequestMapping(method = RequestMethod.POST, path = Endpoints.addCustomer)
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) throws CustomerException {
        CustomerResponse customerResponse = null;
        customerResponse = customerService.createCustomer(customer);
        return ResponseEntity.ok().body(customerResponse);
    }


    @ApiOperation(nickname = "Update Customer", value = "Update Existing Customer", notes = "Update Existing Customer", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Customer"}, authorizations = {@Authorization(value = "jwtToken")})
    @RequestMapping(method = RequestMethod.PUT, path = Endpoints.updateCustomer)
    public ResponseEntity<?> updateCustomer(@PathVariable long customerId, @RequestBody Customer customer) throws CustomerException {
        CustomerResponse customerResponse = null;
        customerResponse = customerService.updateCustomer(customerId, customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @ApiOperation(nickname = "Update CustomerAddress", value = "Update Customer Address", notes = "Update Customer Address", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Customer"}, authorizations = {@Authorization(value = "jwtToken")})
    @RequestMapping(method = RequestMethod.PUT, path = Endpoints.updateCustomerAddress)
    public ResponseEntity<?> updateCustomerAddress(@PathVariable long customerId, @RequestBody CustomerAddress customerAddress) throws CustomerAddressException {
        CustomerResponse customerResponse = null;
        customerResponse = customerAddressService.updateCustomerAddress(customerId, customerAddress);
        return ResponseEntity.ok().body(customerResponse);
    }

    @ApiOperation(nickname = "Update Customer Contact Details", value = "Update Customer Contact Details", notes = "Update Customer Contact Details", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Customer"}, authorizations = {@Authorization(value = "jwtToken")})
    @RequestMapping(method = RequestMethod.PUT, path = Endpoints.updateCustomerContactDetails)
    public ResponseEntity<?> updateCustomerContactDetails(@PathVariable long customerId, @RequestBody CustomerContactDetails customerContactDetails) throws CustomerContactException {
        CustomerResponse customerResponse = null;
        customerResponse = customerContactService.updateCustomerContact(customerId, customerContactDetails);
        return ResponseEntity.ok().body(customerResponse);
    }
}
