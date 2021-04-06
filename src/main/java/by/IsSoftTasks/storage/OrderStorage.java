package by.IsSoftTasks.storage;

import by.IsSoftTasks.domain.Order;
import java.util.Optional;

public class OrderStorage {

    public Optional<Order> findByUserId(String userId) {
        return Optional.empty();
    }

    public String save(Order order) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    public Order[] load(String userId) {
        throw new UnsupportedOperationException("not implemented yet");
    }

}
