package com.retail.loyality.exception;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;

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


