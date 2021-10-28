package io.codification.DummyDataForExamples;

import java.util.List;

public class Employee {

    private String name;

    private String email;

    private List<Long> phoneNumber = null;

    private Address address;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {

        return email;
    }

    public List<Long> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<Long> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
