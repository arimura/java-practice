package com.hormiga6.javapractice.encoder;

public class Hex {
    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String encodeSlow(byte[] bytes){
        StringBuilder builder = new StringBuilder(bytes.length * 2);
        for (byte b: bytes
             ) {
            builder.append(String.format("%02x",b & 0xff));
        }
        return builder.toString();
    }

    public static String encodeFast(byte[] bytes){
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}
