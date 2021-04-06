package by.IsSoftTasks.storage;

import by.IsSoftTasks.domain.OrderItem;
import org.junit.jupiter.api.Test;

import static by.IsSoftTasks.data.OrderItemData.someValidOrderItem;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class OrderItemStorageTest {

    private OrderItemStorage orderItemStorage = new OrderItemStorage();

    @Test
    public void testSave() {
        String orderId = "someId";
        OrderItem[] orderItems = someValidOrderItem();

        final String id = orderItemStorage.save(orderId, orderItems);

        assertThat(id, is(not(null)));
        final OrderItem[] loaded = orderItemStorage.load(id);
        assertThat(loaded, is(equalTo(orderItems)));
    }
}