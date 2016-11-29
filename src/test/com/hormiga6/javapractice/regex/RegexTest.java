package com.hormiga6.javapractice.regex;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by kotaro.arimura on 2016/11/29.
 */
public class RegexTest {
    @Test
    public void testMatch() {
        //match() is full match.
        assertThat("test/1.1.1)".matches("test"),
                is(false));
        /*
        The backslash \ is an escape character in Java Strings.
        That means backslash has a predefined meaning in Java.
        You have to use double backslash \\ to define a single backslash.
         */
        assertThat("test/1.1.1)"
                        .matches("test/\\d\\.\\d\\.\\d.+"),
                is(true));
    }
}
