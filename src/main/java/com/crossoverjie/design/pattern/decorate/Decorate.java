package com.crossoverjie.design.pattern.decorate;

public class Decorate extends Baisc {
    protected Baisc baisc;

    public Decorate(Baisc val) {
        this.baisc = val;
    }

    @Override
    public String getVal() {
        return baisc.getVal();
    }

    @Override
    public void setVal(String val) {
        baisc.setVal(val);
    }
}
