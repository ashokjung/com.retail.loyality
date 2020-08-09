package com.retail.loyality.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerAddressTest {

    CustomerAddress customerAddress;

    @Before
    public void setup() {
        customerAddress = new CustomerAddress();
        customerAddress.setCustomerId(123l);
        customerAddress.setAddressLine1("AddressLine1");
        customerAddress.setAddressLine2("AddressLine2");
        customerAddress.setAddressLine3("AddressLine3");
        customerAddress.setPostalCode("560064");
        customerAddress.setState("Karnataka");
        customerAddress.setCountry("India");
    }

    @Test
    public void customerAddressTest() {
        Assert.assertEquals(123l,customerAddress.getCustomerId());
        Assert.assertEquals("AddressLine1", customerAddress.getAddressLine1());
        Assert.assertEquals("AddressLine2", customerAddress.getAddressLine2());
        Assert.assertEquals("AddressLine3", customerAddress.getAddressLine3());
        Assert.assertEquals("560064", customerAddress.getPostalCode());
        Assert.assertEquals("Karnataka", customerAddress.getState());
        Assert.assertEquals("India", customerAddress.getCountry());
    }
}
