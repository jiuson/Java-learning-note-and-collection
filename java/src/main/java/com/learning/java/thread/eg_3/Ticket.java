package com.learning.java.thread.eg_3;

/**
 * @program java
 * @author jiuson
 * @create 2019/08/24 14:56
 * @description ticket object
 */
public class Ticket {

    private int ticketNum;
    private String addressStart;
    private String addressEnd;
    private Float price;

    public Ticket(int ticketNum, String addressStart, String addressEnd, Float price) {
        this.ticketNum = ticketNum;
        this.addressStart = addressStart;
        this.addressEnd = addressEnd;
        this.price = price;
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    public String getAddressStart() {
        return addressStart;
    }

    public void setAddressStart(String addressStart) {
        this.addressStart = addressStart;
    }

    public String getAddressEnd() {
        return addressEnd;
    }

    public void setAddressEnd(String addressEnd) {
        this.addressEnd = addressEnd;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNum=" + ticketNum +
                ", addressStart='" + addressStart + '\'' +
                ", addressEnd='" + addressEnd + '\'' +
                ", price=" + price +
                '}';
    }
}
