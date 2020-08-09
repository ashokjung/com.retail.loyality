package com.retail.loyality.models;

import com.retail.loyality.enums.Gender;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerTest {

    Customer customer;
    Customer customers;
    CustomerAddress customerAddress;
    CustomerContactDetails customerContactDetails;
    Date date = new Date();

    @Before
    public void setup() {

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


        customers = new Customer();
        customers.setAge(30);
        customers.setCustomerId(123l);
        customers.setDateOfbirth(date);
        customers.setGender(null);
        customers.setFirstName("FirtName");
        customers.setLastName("LastName");
        customers.setCustomerAddress(customerAddress);
        customers.setCustomerContactDetails(customerContactDetails);

    }

    @Test
    public void customerTest() {
        Assert.assertEquals(date,customer.getDateOfbirth());
        Assert.assertEquals(30, customer.getAge());
        Assert.assertEquals(123l, customer.getCustomerId());
        Assert.assertEquals(Gender.MALE, customer.getGender());
        Assert.assertEquals("FirtName", customer.getFirstName());
        Assert.assertEquals("LastName", customer.getLastName());
        Assert.assertNotNull(customer.getCustomerAddress());
        Assert.assertNotNull(customer.getCustomerContactDetails());

    }

    @Test
    public void customerTestForDefaultGender(){
        Assert.assertEquals(date,customers.getDateOfbirth());
        Assert.assertEquals(30, customers.getAge());
        Assert.assertEquals(123l, customers.getCustomerId());
        Assert.assertEquals(Gender.UNKNOWN, customers.getGender());
        Assert.assertEquals("FirtName", customers.getFirstName());
        Assert.assertEquals("LastName", customers.getLastName());
        Assert.assertNotNull(customers.getCustomerAddress());
        Assert.assertNotNull(customers.getCustomerContactDetails());
    }

}
