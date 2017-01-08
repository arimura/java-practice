package com.hormiga6.javapractice.reference;

import org.junit.Test;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

public class WeakReferenceTest {

    // information
    // https://community.oracle.com/blogs/enicholas/2006/05/04/understanding-weak-references

    @Test
    public void testWeakReference(){
        WeakReference<Object> weakObj = new WeakReference<Object>(new Object());

        assertThat(weakObj.get(),is(notNullValue()));
        System.gc();
        assertThat(weakObj.get(),is(nullValue()));
    }

    @Test
    public void testWeakHashMap(){
        WeakHashMap<Object, Object> map = new WeakHashMap<Object, Object>();
        Object key1 = new Object();

        map.put(key1,new Object());

        assertThat(map.get(key1),is(notNullValue()));
        key1 = null;
        assertThat(map.get(key1),is(nullValue()));
    }
}
