package com.crossoverjie.innerclass;

/**
 * 功能描述 内部类
 *
 * @Author ShareDream.J
 * @Date 2020/12/9 15:32
 */
public class Parcel1 {
    private Parcel1() {
    }

    public Parcel1(String name) {
        this.name = name;
    }

    private String name;

    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        public Destination(String label) {
            this.label = label;
        }

        public String readLable() {
            return label;
        }
    }

    public String ship(String ship) {
        Contents contents = new Contents();
        Destination destination = new Destination(ship);
        System.out.println(destination.readLable());
        return ship;
    }

    public static void main(String[] args) {
        Parcel1 parcel1 = new Parcel1();
        parcel1.ship("xxxx");
    }
}
