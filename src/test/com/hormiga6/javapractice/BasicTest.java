package com.hormiga6.javapractice;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by kotaro.arimura on 2016/11/12.
 */
public class BasicTest {
    @Test
    public void initArray(){
        String[] strArray = new String[]{"hoge","fuga"};
        assertThat(strArray[0],is("hoge"));
        assertThat(strArray[1],is("fuga"));
    }
}
