package com.learning.java.thread.eg_2;

/**
 * @program java
 * @author jiuson
 * @create 2019/08/24 13:34
 * @description thread object
 */
public class MyThread implements Runnable{

    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 1; i < 100; i++){
            System.out.println(name + " run " + i + " meter");
        }
    }
}
