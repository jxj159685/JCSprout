package com.crossoverjie.ref;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.StringBufferInputStream;

public class DataInputTest {
    public static void main(String[] args) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new StringBufferInputStream("E:\\project\\my-style\\JCSprout\\src\\main\\java\\com\\crossoverjie\\ref\\BufferedReadTest.java")));
        int i = 0;
        while (dataInputStream.available() != 0) {
            System.out.println(dataInputStream.readInt());
        }
        dataInputStream.close();
    }
}
