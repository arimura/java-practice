package com.hormiga6.javapractice.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kotaro.arimura on 2016/11/10.
 */
public class Zoo {
    private List<Animal> animals = new ArrayList<Animal>();

    public <T extends Animal & Runner> void keepRunnerAnimal(T animal){
        animal.equals(animal);
    }
}
