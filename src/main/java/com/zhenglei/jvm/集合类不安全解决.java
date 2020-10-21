package com.zhenglei.jvm;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class 集合类不安全解决 {
    public static void main(String[] args) {
        /**
         * CopyOnWriteArraySet: 底层是CopyOnWriteArrayList
         *   构造方法：new CopyOnWriteArrayList<E>();
         *   继承的有：AbstractSet
         */
        new CopyOnWriteArraySet<String>().add("11");

        //CopyOnWriteArrayList
        List<String> list = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }

    }
}
