package com.hormiga6.javapractice.system;

import org.junit.Test;

import java.util.Iterator;
import java.util.Map;

public class SystemTest {
    @Test
    public void testGetEnv() {
        Iterator<Map.Entry<Object, Object>> iterator = System.getProperties().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Object, Object> entry = iterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
