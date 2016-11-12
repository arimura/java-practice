package com.hormiga6.javapractice.encoder;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by kotaro.arimura on 2016/11/12.
 */
public class HexTest {
    @Test
    public void testEncodeSlow() throws UnsupportedEncodingException {
        assertThat(Hex.encodeSlow("ABCDEF".getBytes("UTF-8")), is("414243444546"));
    }

    @Test
    public void testEncodeFast() throws UnsupportedEncodingException {
        assertThat(Hex.encodeFast("ABCDEF".getBytes("UTF-8")), is("414243444546"));
    }

    @Test
    public void testApacheCodec() throws UnsupportedEncodingException {
        assertThat(org.apache.commons.codec.binary.Hex.encodeHexString("ABCDEF".getBytes("UTF-8")), is("414243444546"));
    }
}