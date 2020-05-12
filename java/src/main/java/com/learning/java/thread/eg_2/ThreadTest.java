package com.learning.java.thread.eg_2;

/**
 * @program java
 * @author jiuson
 * @create 2019/08/24 13:36
 * @description thread test
 */
public class ThreadTest {

    public static void main(String[] args){
        MyThread myThread = new MyThread("A");
        MyThread myThread1 = new MyThread("B");
        MyThread myThread2 = new MyThread("C");

        Thread thread = new Thread(myThread);
        Thread thread1 = new Thread(myThread1);
        Thread thread2 = new Thread(myThread2);

        thread.start();
        thread1.start();
        thread2.start();
    }
}
