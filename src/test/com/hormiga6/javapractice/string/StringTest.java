package com.hormiga6.javapractice.string;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StringTest {
    @Test
    public void testIntern() {
        assertThat("test".intern(), is("test"));
        assertThat("test".intern() == "test".intern(), is(true));
        assertThat("test".intern() == "hoge".intern(), is(false));
    }
}
