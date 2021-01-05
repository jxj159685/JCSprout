package com.crossoverjie.ref;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;

public class ViewBuffer {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[]{0, '0', '0', '0', '0', '0', '0', 'a'});
        byteBuffer.rewind();
        while (byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.position() + "---" + byteBuffer.get());
        }

        CharBuffer charBuffer = ((ByteBuffer) byteBuffer.rewind()).asCharBuffer();
        while (charBuffer.hasRemaining()) {
            System.out.println(charBuffer.position() + "---" + charBuffer.get());
        }
        DoubleBuffer doubleBuffer = ((ByteBuffer) byteBuffer.rewind()).asDoubleBuffer();
        while (doubleBuffer.hasRemaining()) {
            System.out.println(doubleBuffer.position() + "---" + doubleBuffer.get());
        }

    }
}
