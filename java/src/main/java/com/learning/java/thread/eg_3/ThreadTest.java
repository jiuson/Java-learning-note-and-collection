package com.learning.java.thread.eg_3;

import java.util.Vector;

/**
 * @program java
 * @author jiuson
 * @create 2019/08/24 15:07
 * @description thread test
 */
public class ThreadTest {

    static Vector<Ticket> tickets = new Vector<Ticket>();//用Vector保证线程安全，避免出现多个窗口售出相同车票

    //通过静态代码块初始化车票
    static {
        for (int i = 0; i < 100; i++) {
            tickets.add(new Ticket(i + 1, "北京", "上海", (i / 5) * 25F));
        }
    }

    public static void main(String[] args){


        SellTicketWindow sellTicketWindow = new SellTicketWindow("北京站", tickets);
        SellTicketWindow sellTicketWindow1 = new SellTicketWindow("北京南站", tickets);
        SellTicketWindow sellTicketWindow2 = new SellTicketWindow("北京西站", tickets);

        sellTicketWindow.start();
        sellTicketWindow1.start();
        sellTicketWindow2.start();
    }
}
