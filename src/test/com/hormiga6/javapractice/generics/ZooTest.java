package com.hormiga6.javapractice.generics;

import org.junit.Test;

import static org.junit.Assert.*;

public class ZooTest {
    @Test
    public void testKeepRunnerAnimal(){
        Zoo zoo = new Zoo();
        zoo.keepRunnerAnimal(new Dog("Lucky"));
    }

    static class Dog extends Animal implements Runner {
        public Dog(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("Bow Wow");
        }
    }
}