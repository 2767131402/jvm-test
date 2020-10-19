package com.zhenglei.jvm;

/**
 * volatile不保证原子性 验证
 */

class MyData1 {
    volatile int num = 0;

    public void addNum() {
        this.num++;
    }
}

public class volatile不保证原子性 {

    public static void main(String[] args) {
        MyData1 data = new MyData1();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    data.addNum();
                }
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println("finally num is:" + data.num);
    }
}
