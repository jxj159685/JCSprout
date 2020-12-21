package com.crossoverjie.design.pattern.decorate;

public class ComCoffer {
    private String desc = "的咖啡";

    public ComCoffer() {
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    String getCoffee() {
        return desc;
    }
}
