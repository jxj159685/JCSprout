package com.crossoverjie.niodemo;

import java.nio.ByteBuffer;

public class Dome9 {
    public static void main(String[] args) throws Exception {
        byte[] bytes = new byte[]{'a', 'b', 'c'};
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        //原先的byte数组会影响缓存
        bytes[0] = 'b';
        byteBuffer.put(2, (byte) 'b');
        for (int i = 0; i < byteBuffer.capacity(); i++) {
            System.out.println((char) byteBuffer.get());
        }
    }
}
