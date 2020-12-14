package com.crossoverjie.design.pattern.decorate;

public class Soldier extends Farmer {

    private Farmer farmer;
    final static String describe = "战士";
    final static double power = 200.00;

    public Soldier(Farmer warlock) {
        this.farmer = warlock;
    }

    @Override
    public String getDescribe() {
        return super.getDescribe() + farmer.getDescribe();
    }

    @Override
    protected double power() {
        return farmer.power() + power;
    }
}
