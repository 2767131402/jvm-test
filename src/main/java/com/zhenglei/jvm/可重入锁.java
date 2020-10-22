package com.zhenglei.jvm;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Demo implements Runnable{

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        get();
    }

    private void get() {
        // 两把锁
        lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\tget...");
            set();
        }finally {
            //加锁两次 ，解锁就必须是两次
            lock.unlock();
            lock.unlock();
        }
    }

    private void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\tset...");
        }finally {
            lock.unlock();
        }
    }
}

public class 可重入锁 {
    public synchronized void sendMsg(){
        System.out.println(Thread.currentThread().getName()+"\tsendMsg...");
        sendEmail();
    }
    public synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getName()+"\tsendEmail...");
    }

    public static void main(String[] args) throws Exception {
        可重入锁 lock = new 可重入锁();
        new Thread(()->{
            lock.sendMsg();
        },"t1").start();
        new Thread(()->{
            lock.sendMsg();
        },"t2").start();

        TimeUnit.SECONDS.sleep(1);

        System.out.println();
        System.out.println();
        System.out.println();

        Demo demo = new Demo();
        Thread thread1 = new Thread(demo);
        Thread thread2 = new Thread(demo);
        thread1.start();
        thread2.start();
    }

}
