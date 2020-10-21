package com.zhenglei.jvm;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

class User{
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class Atomic {
//    public static void main(String[] args) {
//        AtomicInteger data = new AtomicInteger(5);
//        System.out.println(data.compareAndSet(5, 100)+"\t"+data.get());
//        System.out.println(data.compareAndSet(5, 200)+"\t"+data.get());
//    }
    public static void main(String[] args) {
        User u1 = new User("zs",22);
        User u2 = new User("ls",25);
        AtomicReference<User> reference = new AtomicReference<>();
        reference.set(u1);

        System.out.println(reference.compareAndSet(u1,u2)+"\t"+reference.get());
        System.out.println(reference.compareAndSet(u1,u2)+"\t"+reference.get());

    }
}
