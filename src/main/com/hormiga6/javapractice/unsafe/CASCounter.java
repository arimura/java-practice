package com.hormiga6.javapractice.unsafe;

import sun.misc.Unsafe;
import sun.reflect.ReflectionFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class CASCounter {
    private long counter = 0;
    private Unsafe unsafe;
    private long offset;

    public CASCounter() throws Exception {
        unsafe = getUnsafe();
        offset = unsafe.objectFieldOffset(CASCounter.class.getDeclaredField("counter"));
    }

    public static Unsafe getUnsafe(){
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe) f.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void increment() {
        long before = counter;
        while(!unsafe.compareAndSwapLong(this,offset, before, before + 1)) {
            before = counter;
        }
    }

    public long getCounter(){
        return counter;
    }

    static class Client implements Runnable {
        private CASCounter c;
        private int num;

        public Client(CASCounter c, int num) {
            this.c = c;
            this.num = num;
        }

        @Override
        public void run() {
            for (int i = 0; i < num; i++){
                c.increment();
            }
        }
    }
}
