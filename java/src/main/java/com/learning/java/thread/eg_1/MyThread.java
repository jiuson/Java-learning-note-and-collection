package com.learning.java.thread.eg_1;

/**
 * @program java
 * @author jiuson
 * @create 2019/08/24 13:23
 * @description thread object
 */
public class MyThread extends Thread{

    private String tName;

    public MyThread(String tName){
        this.tName = tName;
    }

    @Override
    public void run() {

        for (int i = 1; i < 100; i++){
            System.out.println(tName + "has run " + i + " meter");
        }
    }
}
