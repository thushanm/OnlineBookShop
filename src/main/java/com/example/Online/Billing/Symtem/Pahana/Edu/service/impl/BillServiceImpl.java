package com.example.Online.Billing.Symtem.Pahana.Edu.service.impl;

import com.example.Online.Billing.Symtem.Pahana.Edu.dto.BillDTO;
import com.example.Online.Billing.Symtem.Pahana.Edu.entity.Bill;
import com.example.Online.Billing.Symtem.Pahana.Edu.entity.Customer;
import com.example.Online.Billing.Symtem.Pahana.Edu.repository.BillRepository;
import com.example.Online.Billing.Symtem.Pahana.Edu.repository.CustomerRepository;
import com.example.Online.Billing.Symtem.Pahana.Edu.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void createAndSaveBill(BillDTO billDTO) {
        Customer customer = customerRepository.findById(billDTO.getCustomerId()).orElseThrow(() -> new RuntimeException("Customer not found"));

        double totalAmount = calculateTotalAmount(billDTO.getUnitsConsumed());

        Bill bill = new Bill();
        bill.setCustomer(customer);
        bill.setUnitsConsumed(billDTO.getUnitsConsumed());
        bill.setTotalAmount(totalAmount);
        bill.setBillDate(LocalDate.now());

        billRepository.save(bill);
    }

    private double calculateTotalAmount(int unitsConsumed) {
        // Simple billing logic: Rs. 10 per unit
        return unitsConsumed * 10.0;
    }
}
