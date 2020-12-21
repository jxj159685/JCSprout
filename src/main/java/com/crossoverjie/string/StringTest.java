package com.crossoverjie.string;

public class StringTest {
    public static void main(String[] args) {
        String x = "123p";
        String y = "123p";
        String z = x.toUpperCase().toLowerCase();
        System.out.println(z == y);

    }
}
