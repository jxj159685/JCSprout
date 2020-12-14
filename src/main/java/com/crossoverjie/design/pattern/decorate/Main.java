package com.crossoverjie.design.pattern.decorate;

public class Main {
    public static void main(String[] args) {
        Farmer warlock = new Warlock();
        warlock = new Soldier(warlock);
        warlock = new Soldier(warlock);
        warlock = new Soldier(warlock);
        warlock = new Soldier(warlock);
        warlock = new Soldier(warlock);
        warlock = new Soldier(warlock);
        warlock = new Soldier(warlock);
        System.out.println(warlock.power());
    }
}
