package com.learning.java.thread.eg_4_producerAndConsumer_1;

/**
 * @program java
 * @author jiuson
 * @create 2019/08/24 16:30
 * @description Consumer thread object
 */
public class ConsumerThread extends Thread{

    private String tName;
    private Warehouse warehouse;

    public ConsumerThread(String tName, Warehouse warehouse) {
        this.tName = tName;
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        if (warehouse.stringArrayList.size() > 0){
            System.out.println("消费者：" + tName + " ");warehouse.stringArrayList.remove(0);
        }
    }
}
