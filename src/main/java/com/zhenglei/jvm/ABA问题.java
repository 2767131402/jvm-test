package com.zhenglei.jvm;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class ABA问题 {
    static AtomicReference<Integer> reference = new AtomicReference<>(100);

    public static void main(String[] args) {
        new Thread(()->{
            reference.compareAndSet(100,101);
            reference.compareAndSet(101,100);
        },"t1").start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {}
            System.out.println(reference.compareAndSet(100, 2019)+"\t"+reference.get());
        },"t2").start();

        System.out.println("=========ABA问题解决=========");
    }
}
