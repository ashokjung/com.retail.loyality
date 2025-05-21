package com.retail.loyality.exception;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(MockitoJUnitRunner.class)
public class CustomizedResponseEntityExceptionHandlerTest {

    private MockMvc mockMvc;

    @Mock
    private CustomizedResponseEntityExceptionHandler customizedResponseEntityExceptionHandler;

    @Before
    public void setup() {

    }


    @Test
    public void checkUnexpectedExceptionsAreCaughtAndStatusCode500IsReturnedInResponse()  {


    }
}


