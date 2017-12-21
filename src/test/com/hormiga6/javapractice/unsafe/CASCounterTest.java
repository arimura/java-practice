package com.hormiga6.javapractice.unsafe;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class CASCounterTest {
    @Test
    public void count() throws Exception {
        new CASCounter();

        int NUM_OF_THREADS = 1000;
        int NUM_OF_INCREMENTS = 100000;
        ExecutorService service = Executors.newFixedThreadPool(NUM_OF_THREADS);
        CASCounter counter = new CASCounter();
        long before = System.currentTimeMillis();
        for (int i = 0; i < NUM_OF_THREADS; i++) {
            service.submit(new CASCounter.Client(counter, NUM_OF_INCREMENTS));
        }
        service.shutdown();
        service.awaitTermination(1, TimeUnit.MINUTES);
        long after = System.currentTimeMillis();
        System.out.println("Counter result: " + counter.getCounter());
        System.out.println("Time passed in ms:" + (after - before));
    }

}