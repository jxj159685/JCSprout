package com.crossoverjie.clazz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class ShowMethods {
    private static String usage =
            "usage: \n" +
                    "ShowMethods qualified.class.name\n" +
                    "To show all methods in class or: \n" +
                    "ShowMethods qualified.class.name word\n" +
                    "To search for methods involving 'word'";
    private static Pattern pattern = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            Class<?> clazz = Class.forName(args[0]);
            Method[] methods = clazz.getMethods();
            Constructor<?>[] constructors = clazz.getConstructors();
            if (args.length == 1) {
                for (Method method : methods) {
                    System.out.println(pattern.matcher(method.toString()).replaceAll(""));
                }
                for (Constructor<?> constructor : constructors) {
                    System.out.println(pattern.matcher(constructor.toString()));
                }
                lines = methods.length + constructors.length;
            } else {
                for (Method method : methods) {
                    if (method.toString().indexOf(args[1]) != -1) {
                        System.out.println(pattern.matcher(method.toString()).replaceAll(""));
                        lines++;
                    }
                }
                for (Constructor ctor : constructors) {
                    if (ctor.toString().indexOf(args[1]) != -1) {
                        System.out.println(pattern.matcher(ctor.toString()).replaceAll(""));
                        lines++;
                    }
                }
            }
        } catch (Throwable throwable) {
            System.out.println(throwable.getStackTrace());
        }
    }

}
