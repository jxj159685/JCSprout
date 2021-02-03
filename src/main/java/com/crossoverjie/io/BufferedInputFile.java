package com.crossoverjie.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {
    public static String read(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String s;
        StringBuffer stringBuffer = new StringBuffer();
        while ((s=bufferedReader.readLine()) !=null){
            stringBuffer.append(s);
        }
        bufferedReader.close();
        return stringBuffer.toString();
    }
    public static void main(String[] args) throws IOException {
        read("BufferedInputFile.java");
    }
}
