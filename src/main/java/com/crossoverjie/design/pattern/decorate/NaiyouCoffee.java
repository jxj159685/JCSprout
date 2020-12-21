package com.crossoverjie.design.pattern.decorate;

public class NaiyouCoffee extends ComCoffer {

    protected ComCoffer comCoffer;

    private String desc = "加了奶油";

    public NaiyouCoffee(ComCoffer comCoffer) {
        this.comCoffer = comCoffer;
    }

    String getCoffee() {
        return desc + comCoffer.getCoffee();
    }
}
