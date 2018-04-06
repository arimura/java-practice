package com.hormiga6.javapractice.lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class PersonUtil {
    public static void printPersonOlderThan(List<Person> roster, int age){
        for (Person p: roster) {
            if(p.getAge() >= age){
                p.printPerson();
            }
        }
    }

    public static void printPersonWithinAgeRange(List<Person> roaster, int low, int high){
        for (Person p: roaster){
            if(low <= p.getAge() && p.getAge() > high){
                p.printPerson();
            }
        }
    }

    public static void printPersons(List<Person> roaster, CheckPerson tester){
        for (Person p: roaster){
            if(tester.test(p)){
                p.printPerson();
            }
        }
    }

    public static void printPersonsWithPredicate(List<Person> roaster, Predicate<Person> tester){
        for (Person p: roaster){
            if(tester.test(p)){
                p.printPerson();
            }
        }
    }

    public static void processPersons(List<Person> roaster, Predicate<Person> tester, Consumer<Person> block){
        for (Person p: roaster){
            if(tester.test(p)){
                block.accept(p);
            }
        }
    }

    public static void processPersonsWithFunctions(
            List<Person> roaster,
            Predicate<Person> tester,
            Function<Person, String> mapper,
            Consumer<String> block ){
        for (Person p : roaster) {
            if (tester.test(p)){
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public static <X, Y>void processElements(
            Iterable<X> source,
            Predicate<X> tester,
            Function<X, Y> mapper,
            Consumer<Y> block){
                for (X p: source){
                    if(tester.test(p)){
                        Y data = mapper.apply(p);
                        block.accept(data);
                    }
                }
    }

    interface CheckPerson {
        boolean test(Person p);
    }

    interface Predicate<T> {
        boolean test(T t);
    }

    public static class CheckPersonEligibleForSelectiveService implements CheckPerson {

        @Override
        public boolean test(Person p) {
            return p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
        }
    }

}
