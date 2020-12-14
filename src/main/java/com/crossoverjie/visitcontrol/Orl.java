package com.crossoverjie.visitcontrol;

public class Orl extends Villain {
    public Orl(String name, int orlNumber) {
        super(name);
        this.orlNumber = orlNumber;
    }

    private int orlNumber;

    public void change(String name, int orlNumber) {
        setName(name);
        this.orlNumber = orlNumber;
    }

    @Override
    public String toString() {
        return "Orl =" + orlNumber + ",name" + super.toString();
    }


}
