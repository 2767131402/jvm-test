package com.zhenglei.jvm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

public class 集合类不安全 {
    public static void main(String[] args) {
        /**
         * HashSet：底层是HashMap
         * 构造方法：map = new HashMap<>();
         * HashSet 的key是设置的值，value是  new的Object的常量；
         * 即： HashSet只关心key 不关心value
         */
        new HashSet<>().add("11");

        // ArrayList
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }

        /**
         * java.util.ConcurrentModificationException
         * 出现原因：
         *   add 方法没有加锁，导致在多线程争抢修改资源
         */

    }
}
