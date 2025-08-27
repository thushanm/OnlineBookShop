package com.example.Online.Billing.Symtem.Pahana.Edu.service;

import com.example.Online.Billing.Symtem.Pahana.Edu.dto.CustomerDTO;
import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    void saveCustomer(CustomerDTO customerDTO);
    CustomerDTO getCustomerById(Long id);
    void deleteCustomerById(Long id);
}
