package com.crossoverjie.design.pattern.mixedmodel;

public class BasicImpl implements MixBasic {
    private String val;

    @Override
    public void set(String val) {
        this.val = val;
    }

    @Override
    public String get() {
        return val;
    }
}
