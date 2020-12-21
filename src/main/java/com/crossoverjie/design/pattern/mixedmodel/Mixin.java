package com.crossoverjie.design.pattern.mixedmodel;

public class Mixin extends BasicImpl implements SerialNumbered, TimeStamped {
    SerialNumbered serialNumbered = new SerialNumberedImpl();
    TimeStamped timeStamped = new TimeStampedImpl();

    @Override
    public long getSerialNumbered() {
        return serialNumbered.getSerialNumbered();
    }

    @Override
    public long getStamp() {
        return timeStamped.getStamp();
    }

    public Mixin(String val) {
        super.set(val);
    }

    public static void main(String[] args) {
        Mixin m = new Mixin("x");
        System.out.println(m.getSerialNumbered());
        System.out.println(m.get());
    }
}
