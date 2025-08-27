package com.example.Online.Billing.Symtem.Pahana.Edu.service;

import com.example.Online.Billing.Symtem.Pahana.Edu.dto.OrderDTO;
import java.util.List;

public interface OrderService {
    void placeOrder(OrderDTO orderDTO);
    List<OrderDTO> getAllOrders();
}
