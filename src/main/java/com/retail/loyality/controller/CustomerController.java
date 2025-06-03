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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Customer Controller", description = "Operations related to customers")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerAddressService customerAddressService;
    @Autowired
    private CustomerContactService customerContactService;

    @Operation(summary = "Add new Customer", description = "Add new Customer",
                tags = {"Customer"},
                security = @SecurityRequirement(name = "jwtToken"))
    @RequestMapping(method = RequestMethod.POST, path = Endpoints.addCustomer, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) throws CustomerException {
        CustomerResponse customerResponse = null;
        customerResponse = customerService.createCustomer(customer);
        return ResponseEntity.ok().body(customerResponse);
    }


    @Operation(summary = "Update Existing Customer", description = "Update Existing Customer",
                tags = {"Customer"},
                security = @SecurityRequirement(name = "jwtToken"))
    @RequestMapping(method = RequestMethod.PUT, path = Endpoints.updateCustomer, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateCustomer(@PathVariable long customerId, @RequestBody Customer customer)
            throws CustomerException {
        CustomerResponse customerResponse = null;
        customerResponse = customerService.updateCustomer(customerId, customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @Operation(summary = "Update Customer Address", description = "Update Customer Address",
                tags = {"Customer"},
                security = @SecurityRequirement(name = "jwtToken"))
    @RequestMapping(method = RequestMethod.PUT, path = Endpoints.updateCustomerAddress, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateCustomerAddress(@PathVariable long customerId,
                                                   @RequestBody CustomerAddress customerAddress)
            throws CustomerAddressException {
        CustomerResponse customerResponse = null;
        customerResponse = customerAddressService.updateCustomerAddress(customerId, customerAddress);
        return ResponseEntity.ok().body(customerResponse);
    }
    
    @Operation(summary = "Update Customer Contact Details", description = "Update Customer Contact Details",
                
                tags = {"Customer"},
                security = @SecurityRequirement(name = "jwtToken"))
    public ResponseEntity<?> updateCustomerContactDetails(@PathVariable long customerId,
                                                          @RequestBody CustomerContactDetails customerContactDetails)
            throws CustomerContactException {
        CustomerResponse customerResponse = null;
        customerResponse = customerContactService.updateCustomerContact(customerId, customerContactDetails);
        return ResponseEntity.ok().body(customerResponse);
    }
}