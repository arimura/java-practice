package com.hormiga6.javapractice.lambda;

import java.time.LocalDate;

public class Person {
    public enum Sex {
        MALE, FEMALE
    }

    public Person(String name, Sex gender, int age){
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    private String name;
    private Sex gender;
    private int age;
    String emailAddress;

    public String getName() {
        return name;
    }

    public Sex getGender() {
        return gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getAge(){
        return age;
    }

    public void printPerson(){
        System.out.println("name: " + name);
    }
}
