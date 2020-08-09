package com.retail.loyality.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerClubcardTest {

    CustomerClubcard customerClubcard;

    @Before
    public void setup() {
        customerClubcard = new CustomerClubcard();
        customerClubcard.setClubcardId(123l);
        customerClubcard.setClubcardStatus(1);
        customerClubcard.setClubcardType(1);
        customerClubcard.setCustomerId(1234);
        customerClubcard.setPrimaryClubcardId(1234);
    }

    @Test
    public void customerClubcardTest() {

        Assert.assertEquals(123l, customerClubcard.getClubcardId());
        Assert.assertEquals(1, customerClubcard.getClubcardStatus());
        Assert.assertEquals(1, customerClubcard.getClubcardType());
        Assert.assertEquals(1234, customerClubcard.getCustomerId());
        Assert.assertEquals(1234, customerClubcard.getPrimaryClubcardId());

    }
}
