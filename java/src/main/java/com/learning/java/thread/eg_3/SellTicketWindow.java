package com.learning.java.thread.eg_3;

import java.util.Vector;

/**
 * @program java
 * @author jiuson
 * @create 2019/08/24 14:59
 * @description sell ticket window
 */
public class SellTicketWindow extends Thread{

    private String STWName;
    private Vector<Ticket> tickets;

    public SellTicketWindow(String STWName, Vector<Ticket> tickets) {
        this.STWName = STWName;
        this.tickets = tickets;
    }

    @Override
    public void run() {
        while (true){
            if (tickets.size() > 0){
                System.out.println(STWName + " 窗口售出车票：" + tickets.remove(0));
            }else {
                System.out.println(STWName + "，没票啦");
                break;
            }
        }
    }
}
