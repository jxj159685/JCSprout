package com.crossoverjie.visitcontrol;

public class Villain {
    private String name;

    public Villain(String name) {
        this.name = name;
    }

    //包访问控制，导出类可访问
    protected void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "";
    }
}
