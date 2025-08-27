package com.example.Online.Billing.Symtem.Pahana.Edu.service.impl;

import com.example.Online.Billing.Symtem.Pahana.Edu.dto.OrderDTO;
import com.example.Online.Billing.Symtem.Pahana.Edu.entity.Customer;
import com.example.Online.Billing.Symtem.Pahana.Edu.entity.Item;
import com.example.Online.Billing.Symtem.Pahana.Edu.entity.Order;
import com.example.Online.Billing.Symtem.Pahana.Edu.entity.OrderDetail;
import com.example.Online.Billing.Symtem.Pahana.Edu.repository.CustomerRepository;
import com.example.Online.Billing.Symtem.Pahana.Edu.repository.ItemRepository;
import com.example.Online.Billing.Symtem.Pahana.Edu.repository.OrderRepository;
import com.example.Online.Billing.Symtem.Pahana.Edu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void placeOrder(OrderDTO orderDTO) {
        Customer customer = customerRepository.findById(orderDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderDate(LocalDate.now());

        double totalAmount = 0.0;

        for (int i = 0; i < orderDTO.getItemIds().size(); i++) {
            Item item = itemRepository.findById(orderDTO.getItemIds().get(i))
                    .orElseThrow(() -> new RuntimeException("Item not found"));

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setItem(item);
            orderDetail.setQuantity(orderDTO.getQuantities().get(i));
            orderDetail.setPrice(item.getPrice());

            order.getOrderDetails().add(orderDetail);
            totalAmount += item.getPrice() * orderDTO.getQuantities().get(i);
        }

        order.setTotalAmount(totalAmount);
        orderRepository.save(order);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream().map(order -> {
            OrderDTO dto = new OrderDTO();
            dto.setId(order.getId());
            dto.setCustomerId(order.getCustomer().getId());
            dto.setCustomerName(order.getCustomer().getName());
            dto.setOrderDate(order.getOrderDate());
            dto.setTotalAmount(order.getTotalAmount());
            return dto;
        }).collect(Collectors.toList());
    }
}
