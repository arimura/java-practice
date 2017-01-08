package com.hormiga6.javapractice.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayTest {
    @Test
    public void initArray(){
        String[] strArray = new String[]{"hoge","fuga"};
        assertThat(strArray[0],is("hoge"));
        assertThat(strArray[1],is("fuga"));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void arrayIndexing(){
        //no negative index
        String[] strArray = new String[]{"hoge","fuga"};
        assertThat(strArray[-1],is("fuga"));
    }
}
