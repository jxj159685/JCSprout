package com.crossoverjie.clazz;

public class ClazzCast {
    public static void main(String[] args) {
        Building b = new Horse();
        Class<Horse> horseClass = Horse.class;
        Horse cast = horseClass.cast(b);

    }
}

class Building {

}

class Horse extends Building {

}