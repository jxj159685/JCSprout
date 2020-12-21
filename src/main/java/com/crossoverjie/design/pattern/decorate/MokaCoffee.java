package com.crossoverjie.design.pattern.decorate;

public class MokaCoffee extends ComCoffer {

    protected ComCoffer comCoffer;

    private String desc = "加了摩卡";

    public MokaCoffee(ComCoffer comCoffer) {
        this.comCoffer = comCoffer;
    }

    String getCoffee() {
        return desc + comCoffer.getCoffee();
    }
}
