package com.maventest.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "user_order")
public class UserOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "order_name", length = 50)
    private String orderName;
    private int quantity;
    private double price;
    @Column(name = "in_offer")
    private boolean isInOffer;
    @Transient
    private List<String> isOfferInExchange;
    @Temporal(TemporalType.DATE)
    @Column(name = "order_created")
    private Date orderCreated;
    @Lob
    @Column(name = "order_image", length = 10000)
    private byte[] orderImage;

    public UserOrder() {}

    public UserOrder(int orderId, String orderName, int quantity, double price, boolean isInOffer, List<String> isOfferInExchange, Date orderCreated, byte[] orderImage) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.quantity = quantity;
        this.price = price;
        this.isInOffer = isInOffer;
        this.isOfferInExchange = isOfferInExchange;
        this.orderCreated = orderCreated;
        this.orderImage = orderImage;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isInOffer() {
        return isInOffer;
    }

    public void setInOffer(boolean inOffer) {
        isInOffer = inOffer;
    }

    public List<String> getIsOfferInExchange() {
        return isOfferInExchange;
    }

    public void setIsOfferInExchange(List<String> isOfferInExchange) {
        this.isOfferInExchange = isOfferInExchange;
    }

    public Date getOrderCreated() {
        return orderCreated;
    }

    public void setOrderCreated(Date orderCreated) {
        this.orderCreated = orderCreated;
    }

    public byte[] getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(byte[] orderImage) {
        this.orderImage = orderImage;
    }

    @Override
    public String toString() {
        return "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", isInOffer=" + isInOffer +
                ", isOfferInExchange=" + isOfferInExchange +
                ", orderCreated=" + orderCreated;
    }
}