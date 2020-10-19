package com.zhenglei.jvm;

import java.util.concurrent.TimeUnit;

/**
 * volatile 可见性 测试
 */
class MyData{
    volatile int num = 0; // 加上volatile 后 可以保证主内存值 对其他线程 可见
    public void updateNum(){
        this.num = 60;
    }
}

public class JVM可见性 {
    public static void main(String[] args) {
        MyData myData = new MyData();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t come in.");
            myData.updateNum();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {}
            System.out.println(Thread.currentThread().getName()+"\t update num is 60");
        },"AAA").start();

        while (myData.num==0){
            //主线程获取 num 的值
        }
        System.out.println(Thread.currentThread().getName()+"\t main num is 60");
    }
}
