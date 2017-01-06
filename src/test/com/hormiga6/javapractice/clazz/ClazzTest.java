package com.hormiga6.javapractice.clazz;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ClazzTest {
    @Test
    public void testGetResource() {
        URL urlByAbs = getClass().getResource("/com/hormiga6/javapractice/data/hoge.txt");
        assertThat(urlByAbs, not(nullValue()));

        URL urlByWrongPath = getClass().getResource("hoge.txt");
        assertThat(urlByWrongPath, is(nullValue()));
    }

    @Test
    public void testGetResourceAdStrean() {
        InputStream stream = getClass().getResourceAsStream("/com/hormiga6/javapractice/data/hoge.txt");
        try (InputStreamReader streamReader = new InputStreamReader(stream);
             BufferedReader bufferedReader = new BufferedReader(streamReader);) {
            assertThat(bufferedReader.readLine(), is("hogehoge"));
        } catch (IOException e) {
            fail();
        }
    }
}
