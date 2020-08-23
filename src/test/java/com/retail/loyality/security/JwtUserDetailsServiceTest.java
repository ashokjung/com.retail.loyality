package com.retail.loyality.security;

import com.retail.loyality.security.service.JwtUserDetailsService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.catchThrowable;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JwtUserDetailsServiceTest {

    @Autowired
    JwtUserDetailsService jwtUserDetailsService;

    @Test
    public void loadUserByUsernameWithException(){
        Throwable thrown = catchThrowable(() ->
                jwtUserDetailsService.loadUserByUsername("Test"));
        Assertions.assertThat(thrown)
                .isInstanceOf(UsernameNotFoundException.class);
    }
}
