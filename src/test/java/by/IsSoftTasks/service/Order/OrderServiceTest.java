package by.IsSoftTasks.service.Order;

import by.IsSoftTasks.domain.Order;
import by.IsSoftTasks.domain.OrderStatus;
import by.IsSoftTasks.storage.OrderItemStorage;
import by.IsSoftTasks.storage.OrderStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static by.IsSoftTasks.data.OrderTestData.anyOrder;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    private OrderService orderService;

    @Mock
    private OrderValidator orderValidator;

    @Mock
    private OrderStorage orderStorage;

    @Mock
    private OrderItemStorage orderItemStorage;

    @BeforeEach
    public void before(){
        MockitoAnnotations.initMocks(this);

        when(orderStorage.save(any())).thenReturn(UUID.randomUUID().toString());
        orderService = new OrderService(orderStorage, orderValidator, orderItemStorage);
    }

    @Test
    void createOrder_invalid() {
        Order order = anyOrder();
        orderIsValid(order);

        assertThrows(IllegalArgumentException.class, () -> orderService.placeOrder(order));
        verify(orderStorage, never()).save(any());
    }

    @Test
    void placeOrderTest() {
        String userId = "userId";
        when(orderStorage.findByUserId(userId)).thenReturn(Optional.empty());

        Order order = new Order(userId);
        when(orderValidator.validateForCreation(order)).thenReturn(true);

        final String orderId = orderService.placeOrder(order);

        assertNotNull(orderId);
        verify(orderStorage).save(order);
        assertThat(order.getStatus(), is(OrderStatus.INITIAL));
    }

    @Test
    void loadAllByUserIdTest() {
        String userId = "userId";
        when(orderStorage.findByUserId(userId)).thenReturn(Optional.empty());

        Order[] orders = orderService.loadAllByUserId(userId);
        verify(orderStorage).load(userId);
    }

    private void orderIsValid(Order order) {
        when(orderValidator.validateForCreation(order)).thenReturn(false);
    }
}