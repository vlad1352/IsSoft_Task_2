package by.IsSoftTasks.service.Order;

import by.IsSoftTasks.domain.Order;
import by.IsSoftTasks.domain.OrderStatus;
import by.IsSoftTasks.storage.OrderItemStorage;
import by.IsSoftTasks.storage.OrderStorage;
import java.util.*;

import static com.google.common.base.Preconditions.checkState;

public class OrderService {

    private final OrderStorage orderStorage;
    private final OrderValidator orderValidator;
    private final OrderItemStorage orderItemStorage;

    public OrderService(OrderStorage orderStorage, OrderValidator orderValidator, OrderItemStorage orderItemStorage) {
        this.orderStorage = orderStorage;
        this.orderValidator = orderValidator;
        this.orderItemStorage = orderItemStorage;
    }

    public String placeOrder(Order order) {
        final boolean isValid = orderValidator.validateForCreation(order);
        if(!isValid) {
            throw new IllegalArgumentException("order is not valid");
        }

        Optional<Order> byUserId = orderStorage.findByUserId(order.getUserId());
        checkState(byUserId.isEmpty(), "user id is busy");

        order.setStatus(OrderStatus.INITIAL);

        final String orderId = orderStorage.save(order);
        order.setId(orderId);
        orderItemStorage.save(orderId, order.getOrderItems());

        return orderId;

    }

    public Order[] loadAllByUserId(String userId) {

        Optional<Order> byUserId = orderStorage.findByUserId(userId);
        checkState(byUserId.isEmpty(), "user not exist");
        Order[] orders = orderStorage.load(userId);

        return orders;

    }
}
