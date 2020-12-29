package com.crossoverjie.ref;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public class References {
    private static ReferenceQueue<VeryBig> bigReferenceQueue = new ReferenceQueue<>();

    public static void checkQueue() {
        Reference reference = bigReferenceQueue.poll();
        if (null != reference) {
            System.out.println(reference.get());
        }
    }

    public static void main(String[] args) {
        LinkedList<SoftReference<VeryBig>> references = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            references.add(new SoftReference<VeryBig>(new VeryBig("SOFT" + i), bigReferenceQueue));
            System.out.println("JUSY CREATE" + references.getLast());
            checkQueue();
        }

        LinkedList<WeakReference<VeryBig>> references2 = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            references2.add(new WeakReference<>(new VeryBig("WEAK" + i), bigReferenceQueue));
            System.out.println("JUSY CREATE" + references2.getLast());
            checkQueue();
        }
        SoftReference<VeryBig> veryBigSoftReference = new SoftReference<>(new VeryBig("SOFT"));
        WeakReference<VeryBig> weakReference = new WeakReference<>(new VeryBig("WEAK"));
        System.out.println(references2.size());
        System.gc();
        try {
            Thread.sleep(13000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(references2.size());
        System.out.println(veryBigSoftReference.get());
        System.out.println(weakReference.get());
    }
}
