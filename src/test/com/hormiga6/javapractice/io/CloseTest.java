package com.hormiga6.javapractice.io;

import com.sun.management.UnixOperatingSystemMXBean;
import org.junit.Test;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class CloseTest {
    @Test
    public void closeStream() throws IOException {
        FileInputStream is = new FileInputStream("./src/test/com/hormiga6/javapractice/io/hoge.txt");

        logFdCount("before close");
        is.close();
        logFdCount("after close");
    }

    @Test
    public void finishReading() throws IOException {
        FileInputStream is = new FileInputStream("./src/test/com/hormiga6/javapractice/io/hoge.txt");
        BufferedInputStream bis = new BufferedInputStream(is);

        logFdCount("before finish reading");
        byte[] bytes = new byte[1024];
        while((bis.read(bytes, 0, bytes.length)) > -1){}
        logFdCount("after finish reading");
        bis.close();
        //Closing bis is also close file descriptor.
        logFdCount("after close");
    }

    private void logFdCount(String tag) {
        OperatingSystemMXBean os = ManagementFactory.getOperatingSystemMXBean();
        if(os instanceof UnixOperatingSystemMXBean){
            System.out.println("[" + tag +"] number of open fd: " + ((UnixOperatingSystemMXBean) os).getOpenFileDescriptorCount());
        }
    }
}
