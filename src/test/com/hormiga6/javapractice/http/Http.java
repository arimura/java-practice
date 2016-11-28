package com.hormiga6.javapractice.http;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by kotaro.arimura on 2016/11/25.
 */
public class Http {
    @Test
    public void testStatus200() throws IOException {
        URL url = new URL("http://google.com/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        //try to get input stream from 404 throw exception
        try (InputStream inputStream = con.getInputStream();
        ) {
            assertThat(con.getResponseCode(), is(200));
        }
    }

    @Test(expected = IOException.class)
    public void testStatus404withException() throws IOException {
        URL url = new URL("http://google.com/hoge");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        //try to get input stream from 404 throw exception
        try (InputStream inputStream = con.getInputStream();
        ) {
            assertThat(con.getResponseCode(), is(404));
        }
    }

    @Test
    public void testStatus404() throws IOException {
        URL url = new URL("http://google.com/hoge");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        //call method to get data before getting error stream
        con.getResponseCode();
        try (InputStream errorStream= con.getErrorStream();
             BufferedReader reader= new BufferedReader(new InputStreamReader(errorStream));
        ) {
            String str;
            while ((str = reader.readLine()) != null){
                System.out.println(str);
            }
            assertThat(con.getResponseCode(), is(404));
        }
    }

    @Test
    public void testPost() throws IOException {
        URL url = new URL("http://localhost:5000");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        //try to get input stream from 404 throw exception
        try (InputStream inputStream = con.getInputStream();
        ) {
            assertThat(con.getResponseCode(), is(200));
        }
    }
}
