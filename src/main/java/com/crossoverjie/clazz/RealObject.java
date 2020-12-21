package com.crossoverjie.clazz;

public class RealObject implements Interface {
    @Override
    public void doSomething() {
        System.out.println("RealObject " + "doSomething");
    }

    @Override
    public void doOther() {
        System.out.println("RealObject " + "doOther");
    }
}
