package com.hormiga6.javapractice.defaultmethod;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleTimeClientTest {
    @Test
    public void getTime(){
        TimeClient myTimeClient = new SimpleTimeClient();
        System.out.println("Current time: " + myTimeClient.toString());
        System.out.println("Time in California: " +
                myTimeClient.getZonedDateTime("Blah blah").toString());
    }
}