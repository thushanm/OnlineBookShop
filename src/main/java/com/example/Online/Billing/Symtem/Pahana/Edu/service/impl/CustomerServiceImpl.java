package com.example.Online.Billing.Symtem.Pahana.Edu.service.impl;

import com.example.Online.Billing.Symtem.Pahana.Edu.dto.CustomerDTO;
import com.example.Online.Billing.Symtem.Pahana.Edu.entity.Customer;
import com.example.Online.Billing.Symtem.Pahana.Edu.repository.BillRepository;
import com.example.Online.Billing.Symtem.Pahana.Edu.repository.CustomerRepository;
import com.example.Online.Billing.Symtem.Pahana.Edu.repository.OrderRepository;
import com.example.Online.Billing.Symtem.Pahana.Edu.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream().map(customer -> {
            CustomerDTO dto = new CustomerDTO();
            BeanUtils.copyProperties(customer, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        customerRepository.save(customer);
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return customerRepository.findById(id).map(customer -> {
            CustomerDTO dto = new CustomerDTO();
            BeanUtils.copyProperties(customer, dto);
            return dto;
        }).orElse(null);
    }

    @Override
    public void deleteCustomerById(Long id) {
        if (!billRepository.findByCustomerId(id).isEmpty() || !orderRepository.findByCustomerId(id).isEmpty()) {
            throw new RuntimeException("Cannot delete this customer because they have existing bills or orders.");
        }
        customerRepository.deleteById(id);
    }
}
