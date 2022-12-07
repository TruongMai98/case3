package com.casestudymodule3.model;

import java.time.LocalDate;
import java.util.Locale;

public class Order {
    private int orderId;
    private int customerId;
    private String date;
    private boolean status;

    public Order() {
    }

    public Order(int orderId, int customerId, String date, boolean status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.date = date;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
