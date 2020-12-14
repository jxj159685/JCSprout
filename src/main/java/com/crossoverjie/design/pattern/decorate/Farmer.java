package com.crossoverjie.design.pattern.decorate;

public abstract class Farmer {
    final static String describe = "原始农夫";
    final static double power = 100.00;

    public String getDescribe() {
        return describe;
    }

    protected double power() {
        return power;
    }

}
