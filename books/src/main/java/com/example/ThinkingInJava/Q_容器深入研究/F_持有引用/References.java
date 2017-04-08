package com.example.ThinkingInJava.Q_容器深入研究.F_持有引用;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

/**
 * Created by heshixiyang on 2017/1/22.
 */
public class References {
    private static ReferenceQueue<VeryBig> rq=new ReferenceQueue<>();

    public static void checkQueue(){
        Reference<? extends VeryBig> inq=rq.poll();
        if (inq!=null){
            System.out.println(("In queue:" + inq.get()));
        }
    }

    public static void main(String[] args) {
        int size=10;
        if (args.length>0)
            size=new Integer(args[0]);
        LinkedList<SoftReference<VeryBig>> softReferences=new LinkedList<>();
        for (int i = 0; i < size; i++) {
            softReferences.add(new SoftReference<VeryBig>(new VeryBig("Soft "+i),rq));
            System.out.println(("just created:" + softReferences.getLast()));
            checkQueue();
        }
        LinkedList<WeakReference<VeryBig>> weakReferences=new LinkedList<>();
        for (int i = 0; i < size; i++) {
            weakReferences.add(new WeakReference<VeryBig>(new VeryBig("Weak "+i),rq));
            System.out.println(("just created:" + weakReferences.getLast()));
            checkQueue();
        }

        SoftReference<VeryBig> softReference=new SoftReference<VeryBig>(new VeryBig("Soft"));
        WeakReference<VeryBig> weakReference=new WeakReference<VeryBig>(new VeryBig("Weak"));
        System.gc();

        LinkedList<PhantomReference<VeryBig>> phantomReferences=new LinkedList<>();
        for (int i = 0; i < size; i++) {
            phantomReferences.add(new PhantomReference<>(new VeryBig("Phantom "+i),rq));
            System.out.println(("just created:" + phantomReferences.getLast()));
            checkQueue();
        }

    }
}
