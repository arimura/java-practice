package com.hormiga6.javapractice.encoder;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Base64Test {
    @Test
    public void testEncode() throws UnsupportedEncodingException {
        byte[] encode = Base64.getEncoder().encode("ABCDEFG".getBytes("UTF-8"));
        assertThat(new String(encode, StandardCharsets.UTF_8), is("QUJDREVGRw=="));


    }

    @Test
    public void testDecode() throws UnsupportedEncodingException {
        byte[] decode = Base64.getDecoder().decode("QUJDREVGRw==".getBytes("UTF-8"));
        assertThat(new String(decode,StandardCharsets.UTF_8),is("ABCDEFG"));
    }
}
