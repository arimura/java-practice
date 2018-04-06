package com.hormiga6.javapractice.lambda;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PersonUtilTest {

    List<Person> list;

    @Before
    public void setUp(){
        list = new ArrayList<Person>(){{
            add(new Person("hoge", Person.Sex.MALE,20));
            add(new Person("fuga", Person.Sex.MALE,17));
        }};
    }

    @Test
    public void printPerson(){

        PersonUtil.printPersons(list, new PersonUtil.CheckPersonEligibleForSelectiveService());
        PersonUtil.printPersons(list, new PersonUtil.CheckPerson() {
                    public boolean test(Person p) {
                        return p.getGender() == Person.Sex.MALE
                                && p.getAge() >= 18
                                && p.getAge() <= 25;
                    }
                }
        );
        PersonUtil.printPersons(
                list,
                (Person p) -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25);
    }

    @Test
    public void printPersonsWithPredicate(){
        PersonUtil.printPersonsWithPredicate(
                list,
                p -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25);
    }

    @Test
    public void processPersons(){
        PersonUtil.processPersons(
                list,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.printPerson());
    }

    @Test
    public void processPersonsWithFunctions(){
        PersonUtil.processPersonsWithFunctions(
                list,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );
    }

    @Test
    public void processElements(){
        PersonUtil.processElements(
                list,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );
    }

    @Test
    public void processByAggregateOperation(){
        list.stream()
                .filter(
                        p -> p.getGender() == Person.Sex.MALE
                                && p.getAge() >= 18
                                && p.getAge() <= 25)
                .map(p -> p.getEmailAddress())
                .forEach(email -> System.out.println(email));
    }




}