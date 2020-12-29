package com.crossoverjie.ref;

import java.io.*;

public class BufferedReadTest {
    public static String read(String fileName) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String s;
        StringBuffer stringBuffer = new StringBuffer();
        while ((s = fileReader.readLine()) != null) {
            stringBuffer.append(s);
        }
        return stringBuffer.toString();
    }


    public static String readString(String fileName) throws IOException {
        StringReader stringReader = new StringReader(read(fileName));
        int s;
        StringBuffer stringBuffer = new StringBuffer();
        while ((s = stringReader.read()) != -1) {
            System.out.println((char) s);
            stringBuffer.append((char) s);
        }
        return stringBuffer.toString();
    }


    public static String readData(String fileName) throws IOException {
        DataInputStream stringReader = new DataInputStream(new ByteArrayInputStream(read(fileName).getBytes()));
        int s;
        StringBuffer stringBuffer = new StringBuffer();
        while ((s = stringReader.readByte()) != -1) {
            System.out.println((char) s);
            stringBuffer.append((char) s);
        }
        return stringBuffer.toString();
    }


    public static String readFileData(String fileName) throws IOException {
        DataInputStream stringReader = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
        int s;
        StringBuffer stringBuffer = new StringBuffer();
        while (stringReader.available() != 0) {
            s = stringReader.readByte();
            stringBuffer.append((char) s);
        }
        return stringBuffer.toString();
    }

    public static String writeFile(String fileName) throws IOException {
        String file = "xxx.java";
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(new FileWriter(file)));
        String s;
        while ((s = fileReader.readLine()) != null) {
            bufferedWriter.write(s);
        }
        bufferedWriter.close();
        return file;
    }


    public static void main(String[] args) throws IOException {
//        System.out.println(read("E:\\project\\my-style\\JCSprout\\src\\main\\java\\com\\crossoverjie\\ref\\BufferedReadTest.java"));
//        System.out.println(readString("E:\\project\\my-style\\JCSprout\\src\\main\\java\\com\\crossoverjie\\ref\\BufferedReadTest.java"));
//        System.out.println(readFileData("E:\\project\\my-style\\JCSprout\\src\\main\\java\\com\\crossoverjie\\ref\\BufferedReadTest.java"));
        writeFile("E:\\project\\my-style\\JCSprout\\src\\main\\java\\com\\crossoverjie\\ref\\BufferedReadTest.java");
    }
}
