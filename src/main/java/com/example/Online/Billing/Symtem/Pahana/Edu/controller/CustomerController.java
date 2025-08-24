package com.example.Online.Billing.Symtem.Pahana.Edu.controller;

import com.example.Online.Billing.Symtem.Pahana.Edu.entity.Customer;
import com.example.Online.Billing.Symtem.Pahana.Edu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String viewCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "view-customers";
    }

    @GetMapping("/add")
    public String showAddCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "add-customer";
    }

    @PostMapping("/add")
    public String addCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/edit/{id}")
    public String showEditCustomerForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "edit-customer";
    }

    @PostMapping("/edit/{id}")
    public String updateCustomer(@PathVariable("id") Long id, @ModelAttribute("customer") Customer customer) {
        customer.setId(id);
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomerById(id);
        return "redirect:/customers";
    }
}
