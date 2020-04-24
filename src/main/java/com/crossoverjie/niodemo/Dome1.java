package com.crossoverjie.niodemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.IntBuffer;
import java.security.SecureRandom;

public class Dome1 {
    static Logger logger = LoggerFactory.getLogger(Dome1.class);
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(8);
        for (int i=0;i<buffer.capacity();i++){
            int nextInt = new SecureRandom().nextInt(20);
            buffer.put(nextInt);
        }
        buffer.flip();
        while (buffer.hasRemaining()){
            System.out.println(buffer.get());
        }
        logger.info("qw{}", 12, new RuntimeException("1212"));
    }
}
