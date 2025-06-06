package com.retail.loyality.models;

import com.retail.loyality.enums.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Transient;
import java.util.Date;

@Document(collection = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(hidden = true) private long customerId;

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    private String firstName;
    private String lastName;
    private int age;
    private Date dateOfbirth;
    private Gender gender;
    private CustomerAddress customerAddress;
    private CustomerContactDetails customerContactDetails;

   public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDateOfbirth() {
        return dateOfbirth;
    }

    public void setDateOfbirth(Date dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        if (gender == null) {
            this.gender = Gender.UNKNOWN;
        } else {
            this.gender = gender;
        }
    }

    public CustomerAddress getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(CustomerAddress customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerContactDetails getCustomerContactDetails() {
        return customerContactDetails;
    }

    public void setCustomerContactDetails(CustomerContactDetails customerContactDetails) {
        this.customerContactDetails = customerContactDetails;
    }
}
