package by.IsSoftTasks.data;

import by.IsSoftTasks.domain.Order;
import by.IsSoftTasks.domain.OrderItem;

public class OrderItemData {

    public static OrderItem[] someValidOrderItem() {
        OrderItem[] orderItems = { new OrderItem("item 1", 1L, 5L),new OrderItem("item 2", 14L, 34L)};
        return orderItems;
    }

    public static OrderItem anyOrderItem() {
        OrderItem orderItem = new OrderItem("item", 3L,9L);
        return orderItem;
    }
}
