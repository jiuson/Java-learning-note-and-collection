package com.learning.java.thread.eg_4_producerAndConsumer_1;

/**
 * @program java
 * @author jiuson
 * @create 2019/08/24 16:29
 * @description producer thread object
 */
public class ProducerThread extends Thread{

    private String tName;
    private Warehouse warehouse;

    public ProducerThread(String tName, Warehouse warehouse) {
        this.tName = tName;
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            while (true){
                if (warehouse.stringArrayList.size() < 20){
                    warehouse.stringArrayList.add("abc");
                    Thread.sleep(200);
                }else {
                    wait();
                }
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
