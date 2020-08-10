package com.retail.loyality.controller;

import com.retail.loyality.config.Endpoints;
import com.retail.loyality.models.Customer;
import com.retail.loyality.models.CustomerAddress;
import com.retail.loyality.models.CustomerContactDetails;
import com.retail.loyality.service.CustomerAddressService;
import com.retail.loyality.service.CustomerContactService;
import com.retail.loyality.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerAddressService customerAddressService;
    @Autowired
    private CustomerContactService customerContactService;

    @ApiOperation(nickname = "Add Customer", value = "Add new Customer", notes = "Add new Customer", tags = {"StoreOperations"})
    @RequestMapping(method = RequestMethod.POST, path = Endpoints.addCustomer)
    public boolean addCustomer(@RequestBody Customer customer) {
        boolean status;
        status = customerService.createCustomer(customer);
        return status;
    }


    @ApiOperation(nickname = "Update Customer", value = "Update Existing Customer", notes = "Update Existing Customer", tags = {"StoreOperations"})
    @RequestMapping(method = RequestMethod.PUT, path = Endpoints.updateCustomer)
    public boolean updateCustomer(@PathVariable long customerId, @RequestBody Customer customer) {
        boolean status;
        status = customerService.updateCustomer(customerId, customer);
        return status;
    }

    @ApiOperation(nickname = "Update CustomerAddress", value = "Update Customer Address", notes = "Update Customer Address", tags = {"StoreCustomerSupport"})
    @RequestMapping(method = RequestMethod.PUT, path = Endpoints.updateCustomerAddress)
    public boolean updateCustomerAddress(@PathVariable long customerId, @RequestBody CustomerAddress customerAddress) {
        boolean status;
        status = customerAddressService.updateCustomerAddress(customerId, customerAddress);
        return status;
    }

    @ApiOperation(nickname = "Update Customer Contact Details", value = "Update Customer Contact Details", notes = "Update Customer Contact Details", tags = {"CustomerWebApplication"})
    @RequestMapping(method = RequestMethod.PUT, path = Endpoints.updateCustomerContactDetails)
    public boolean updateCustomerContactDetails(@PathVariable long customerId, @RequestBody CustomerContactDetails customerContactDetails) {
        boolean status;
        status = customerContactService.updateCustomerContact(customerId, customerContactDetails);
        return status;
    }
}
