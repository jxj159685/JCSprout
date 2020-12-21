package com.crossoverjie.generic;

public class Holder3<T> {
    private T t;

    private void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public Holder3(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        Holder3<AutoMobile> holder3 = new Holder3<>(new AutoMobile());

    }
}

class AutoMobile {

}
