package by.IsSoftTasks.service.Order;

import by.IsSoftTasks.domain.Order;

public class OrderValidator {

    public boolean validateForCreation(Order order) {
        if(order.getDateOfOrder() == null) {
            return false;
        }

        if(order.getOrderItems() == null) {
            return false;
        }

        if(order.getDeliveryAddress() == null) {
            return false;
        }

        if(order.getUserId() == null) {
            return false;
        }

        return true;
    }
}
