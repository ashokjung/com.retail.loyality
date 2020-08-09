package com.retail.loyality.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerContactDetailsTest {

    CustomerContactDetails customerContactDetails;

    @Before
    public void setup() {
        customerContactDetails = new CustomerContactDetails();
        customerContactDetails.setEveningPhoneNumber("+918095713751");
        customerContactDetails.setDaytimePhoneNumber("+918095713751");
        customerContactDetails.setMobilePhoneNumber("+918095713751");

    }

    @Test
    public void customerContactDetailsTest() {

        Assert.assertEquals("+918095713751", customerContactDetails.getEveningPhoneNumber());
        Assert.assertEquals("+918095713751", customerContactDetails.getDaytimePhoneNumber());
        Assert.assertEquals("+918095713751", customerContactDetails.getMobilePhoneNumber());

    }
}
