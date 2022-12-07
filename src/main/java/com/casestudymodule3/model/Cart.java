package com.casestudymodule3.model;

import java.time.LocalDate;

public class Cart {
    private int cartId;
    private int customerId;
    private LocalDate createDate;
    private boolean status;

    public Cart() {
    }

    public Cart(int cartId, int customerId, LocalDate createDate, boolean status) {
        this.cartId = cartId;
        this.customerId = customerId;
        this.createDate = createDate;
        this.status = status;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
