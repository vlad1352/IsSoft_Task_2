package by.IsSoftTasks.storage;


import by.IsSoftTasks.domain.Order;
import org.junit.jupiter.api.Test;

import static by.IsSoftTasks.data.OrderTestData.anyValidOrder;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class OrderStorageTest {

    private OrderStorage orderStorage = new OrderStorage();

    @Test
    public void testSave() {
        Order order = anyValidOrder();

        final String id = orderStorage.save(order);

        assertThat(id, is(not(null)));
        final Order[] loaded = orderStorage.load(id);
        assertThat(loaded, is(equalTo(order)));
    }

}