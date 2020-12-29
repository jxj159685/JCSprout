package com.crossoverjie.ref;

import java.lang.ref.SoftReference;

public class SoftReferenceTest {
    private final static int MB = 1024 * 1024;
    byte[] bytes = new byte[4 * MB];

    public static void main(String[] args) {
        SoftReference<SoftReferenceTest> op = new SoftReference<>(new SoftReferenceTest());
//        SoftReferenceTest softReferenceTest = new SoftReferenceTest();
        byte[] bytes1 = new byte[4 * MB];
        System.out.println(op.get());
    }
}
