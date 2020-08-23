package com.retail.loyality.security;

import com.retail.loyality.security.request.JwtRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JwtRequestTest {

    JwtRequest jwtRequest;

    @Before
    public void setup()
    {
        jwtRequest = new JwtRequest("Test","Test");
    }

    @Test
    public void customerAddressTest()
    {
        Assert.assertEquals("Test", jwtRequest.getPassword());
        Assert.assertEquals("Test",jwtRequest.getUsername());
    }
}
