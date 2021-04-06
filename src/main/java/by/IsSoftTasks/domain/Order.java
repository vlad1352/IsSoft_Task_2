package by.IsSoftTasks.domain;

import java.time.LocalDate;
import java.util.*;

public class Order {

    private String id;
    private final String userId;
    private String deliveryAddress;
    private OrderItem[] orderItems;
    private LocalDate dateOfOrder;
    private OrderStatus status;

    public Order(String userId) {
        this.userId = userId;
    }

    public Order(String userId, OrderItem[] orderItems) {
        this.userId = userId;
        this.orderItems = orderItems;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }


    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public OrderItem[] getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(OrderItem[] orderItems) {
        this.orderItems = orderItems;
    }

    public LocalDate getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(LocalDate dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
