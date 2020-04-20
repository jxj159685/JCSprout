package com.crossoverjie.niodemo;

import java.nio.ByteBuffer;

public class Slice {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte) i);
        }
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        buffer.position(5);
        ByteBuffer slice = buffer.slice();
        System.out.println(slice.position());
        System.out.println(slice.capacity());
        System.out.println(buffer.capacity());
        slice.put((byte) 11);
        slice.put((byte) 12);
        slice.put((byte) 13);
        System.out.println(slice.position());
        System.out.println(buffer.position());
        for (int i = 0; i < buffer.capacity(); i++) {
            System.out.println(buffer.get(i));
        }
    }
}
