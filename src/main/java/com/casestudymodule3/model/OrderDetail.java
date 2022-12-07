package com.casestudymodule3.model;

public class OrderDetail {
    private int oderId;
    private int productId;
    private float price;
    private int quantity;

    public OrderDetail() {
    }

    public OrderDetail(int oderId, int productId, float price, int quantity) {
        this.oderId = oderId;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }

    public int getOderId() {
        return oderId;
    }

    public void setOderId(int oderId) {
        this.oderId = oderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
