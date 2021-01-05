package com.crossoverjie.ref;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ByteArrayInputTest {
    public static void main(String[] args) throws IOException {
        BufferedReader byteArrayInputStream = new BufferedReader(new InputStreamReader(System.in));
        char c;
        do {
            c = (char) byteArrayInputStream.read();
            System.out.println(c);
        } while (c != 'q');
    }
}
