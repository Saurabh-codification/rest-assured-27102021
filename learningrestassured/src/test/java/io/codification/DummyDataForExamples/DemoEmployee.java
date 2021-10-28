package io.codification.DummyDataForExamples;

import java.util.LinkedList;
import java.util.List;

import org.testng.annotations.Test;

public class DemoEmployee {

    @Test
    public void createEmployeeObject(){


        Employee saurabh = new Employee();

        List<Long> phoneNumbers = new LinkedList<>();

        phoneNumbers.add(34783257349l);
        phoneNumbers.add(347832457345l);
        phoneNumbers.add(347832428937l);
        phoneNumbers.add(3478324399278l);

        Address homeAddressSaurabh = new Address();

        homeAddressSaurabh.setType("Home");
        homeAddressSaurabh.setPincode(122001);

        saurabh.setName("Saurabh");
        saurabh.setEmail("saurabh.d2106@gmail.com");
        saurabh.setPhoneNumber(phoneNumbers);
        saurabh.setAddress(homeAddressSaurabh);

    }
    
}
