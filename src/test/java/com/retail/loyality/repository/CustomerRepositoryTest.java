package com.retail.loyality.repository;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import com.retail.loyality.enums.Gender;
import com.retail.loyality.exception.CustomerException;
import com.retail.loyality.models.Customer;
import com.retail.loyality.models.CustomerAddress;
import com.retail.loyality.models.CustomerContactDetails;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerRepositoryTest {

    Customer customer;
    CustomerAddress customerAddress;
    CustomerContactDetails customerContactDetails;
    Date date;
    long customerId;
    boolean status;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private MongoOperations mongoOperations;

    @Mock
    private CustomerDaoRepository customerDaoRepository;

    @InjectMocks
    private CustomerDaoRepositoryImpl customerDaoRepositoryImpl;

    @Before
    public void setup()
    {
        customerId=123l;
        date= new Date();
        status = Boolean.TRUE;
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
        customer.setDateOfbirth(date);
        customer.setGender(Gender.MALE);
        customer.setFirstName("FirtName");
        customer.setLastName("LastName");
        customer.setCustomerAddress(customerAddress);
        customer.setCustomerContactDetails(customerContactDetails);
    }

    @Test
    public void addCustomerTest() throws CustomerException {
        when(customerRepository.save(customer)).thenReturn(Mockito.any());
        customerDaoRepositoryImpl.createCustomer(customer);
    }

    @Test
    public void updateCustomerTest() throws CustomerException {
        when(mongoOperations.findAndReplace(Mockito.any(Query.class),Mockito.any())).thenReturn(customer);
        customerDaoRepositoryImpl.updateCustomer(customerId,customer);
    }

    @Test
    public void addCustomerTestException() throws CustomerException {
        doThrow(new CustomerException("Invalid Customer")).when(customerDaoRepository).createCustomer(Mockito.any());
        Throwable thrown = catchThrowable(() ->
                customerDaoRepository.createCustomer(null)
        );
        Assertions.assertThat(thrown)
                .isInstanceOf(CustomerException.class);
    }

    @Test
    public void updateCustomerTestException() throws CustomerException {

        doThrow(new CustomerException("Repository layer: Error while Processing  Updating Customer Information")).when(customerDaoRepository).updateCustomer(Mockito.anyLong(),Mockito.any());
        Throwable thrown = catchThrowable(() ->
                customerDaoRepository.updateCustomer(customerId,null)
        );
        Assertions.assertThat(thrown)
                .isInstanceOf(CustomerException.class);
    }
}
