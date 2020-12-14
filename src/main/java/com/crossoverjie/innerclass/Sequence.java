package com.crossoverjie.innerclass;

public class Sequence {
    private Object[] items;

    private int next = 0;

    public Sequence(int size) {
        this.items = new Object[size];
    }

    public void addItem(Object item) {
        if (next < items.length)
            items[next++] = item;
    }

    //内部类为了复用？
    class SequenceGenerate {
        public boolean end() {
            return next <= 0;
        }

        public Object next() {
            return items[--next];
        }
    }


    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.addItem(i);
        }
        SequenceGenerate sequenceGenerate = sequence.getSelect();
        while (!sequenceGenerate.end()) {
            System.out.println(sequenceGenerate.next());
        }
    }

    private SequenceGenerate getSelect() {
        return new SequenceGenerate();
    }
}
