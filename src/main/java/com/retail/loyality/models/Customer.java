package com.retail.loyality.models;

import com.retail.loyality.enums.Gender;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Customer {

    @Id
    private long customerId;
    private String firstName;
    private String lastName;
    private int  age;
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
        if(gender==null){
            this.gender=Gender.UNKNOWN;
        }
        else{
        this.gender = gender;}
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
