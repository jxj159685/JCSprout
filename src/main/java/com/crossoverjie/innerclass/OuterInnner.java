package com.crossoverjie.innerclass;

public class OuterInnner {
    private int xxx = 1;

    private String getName() {
        return "xja";
    }

    // 内部类貌似实现了多继承 既有当前类的属性，也有继承类的属性
    class Zzz extends Parcel1 {

        public Zzz(String name) {
            super(name);
        }

        public String getInName() {
            return getName() + ship("");
        }
    }

    Zzz getZzz() {
        return new Zzz("kjoaisa");
    }

    class ExZzz extends Zzz {

        public ExZzz(String name) {
            super(name);
        }
    }

//    public static void main(String[] args) {
//        OuterInnner outerInnner = new OuterInnner();
//        System.out.println(outerInnner.getZzz().getInName());
//    }

}


