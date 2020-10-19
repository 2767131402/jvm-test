package com.zhenglei.jvm;


class MyData{
    int num = 0;
    public void updateNum(){
        this.num = 60;
    }
}

public class JVM可见性 {
    public static void main(String[] args) {
        MyData myData = new MyData();

        new Thread(()—>{})
    }
}
