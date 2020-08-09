package com.retail.loyality.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {

    @ApiOperation(nickname = "Add Customer", value = "Add new Customer", notes = "CustomerController", tags = {"StoreOperations"})
    @RequestMapping(method = RequestMethod.POST, path = "/addCustomer")
    public boolean addCustomer(String Customer) {
        return true;
    }


    @ApiOperation(nickname = "Update Customer", value = "Update Existing Customer", notes = "CustomerController", tags = {"StoreOperations"})
    @RequestMapping(method = RequestMethod.POST, path = "/updateCustomer")
    public boolean updateCustomer(String Customer) {
        return true;
    }

    @ApiOperation(nickname = "Update CustomerAddress", value = "Update CustomerAddress", notes = "CustomerController", tags = {"StoreCustomerSupport"})
    @RequestMapping(method = RequestMethod.POST, path = "/updateCustomerAddress")
    public boolean updateCustomerAddress(String Customer) {
        return true;
    }

    @ApiOperation(nickname = "Update Customer Details", value = "Update Customer Details", notes = "CustomerController", tags = {"CustomerWebApplication"})
    @RequestMapping(method = RequestMethod.POST, path = "/updateCustomerDetails")
    public boolean updateCustomerDetails(String Customer) {
        return true;
    }
}
