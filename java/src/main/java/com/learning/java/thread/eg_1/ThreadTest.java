package com.learning.java.thread.eg_1;

/**
 * @program java
 * @author jiuson
 * @create 2019/08/24 13:28
 * @description thread test
 */
public class ThreadTest {

    public static void main(String[] args){
        MyThread myThread = new MyThread("A ");
        MyThread myThread1 = new MyThread("B ");
        MyThread myThread2 = new MyThread("C ");

        myThread.start();
        myThread1.start();
        myThread2.start();
    }
}
