package com.crossoverjie.design.pattern.decorate;

public class Warlock extends Farmer {
    final static String describe = "术士";
    final static double power = 300.00;

    @Override
    public String getDescribe() {
        return super.getDescribe() + describe;
    }

    @Override
    protected double power() {
        return super.power() + power;
    }
}
