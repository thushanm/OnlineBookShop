package com.example.Online.Billing.Symtem.Pahana.Edu.controller;

import com.example.Online.Billing.Symtem.Pahana.Edu.dto.OrderDTO;
import com.example.Online.Billing.Symtem.Pahana.Edu.service.CustomerService;
import com.example.Online.Billing.Symtem.Pahana.Edu.service.ItemService;
import com.example.Online.Billing.Symtem.Pahana.Edu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ItemService itemService;

    @GetMapping
    public String viewOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "view-orders";
    }

    @GetMapping("/place")
    public String showPlaceOrderForm(Model model) {
        model.addAttribute("order", new OrderDTO());
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("items", itemService.getAllItems());
        return "place-order";
    }

    @PostMapping("/place")
    public String placeOrder(@ModelAttribute("order") OrderDTO orderDTO, RedirectAttributes redirectAttributes) {
        try {
            orderService.placeOrder(orderDTO);
            return "redirect:/orders";
        } catch (RuntimeException e) {

            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/orders/place";
        }
    }
}
