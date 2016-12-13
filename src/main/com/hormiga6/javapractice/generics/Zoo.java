package com.hormiga6.javapractice.generics;

import java.util.ArrayList;
import java.util.List;

public class Zoo<T extends Animal & Runner>  {
    private List<T> runningAnimals = new ArrayList<T>();
    private List<Runner> runners = new ArrayList<Runner>();
    private List<Animal> animals = new ArrayList<Animal>();

    public void keepRunnerAnimal(T animal){
        animal.equals(animal);
    }

    public <T1 extends Animal, T2 extends Runner> void keep(T1 am ,T2 a){

    }
}
