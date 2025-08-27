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
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void createAndSaveBill(BillDTO billDTO) {
        Customer customer = customerRepository.findById(billDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + billDTO.getCustomerId()));

        double totalAmount = calculateTotalAmount(billDTO.getUnitsConsumed());

        Bill bill = new Bill();
        bill.setCustomer(customer);
        bill.setUnitsConsumed(billDTO.getUnitsConsumed());
        bill.setTotalAmount(totalAmount);
        bill.setBillDate(LocalDate.now());

        billRepository.save(bill);
    }

    @Override
    public List<BillDTO> getAllBills() {
        return billRepository.findAll().stream().map(bill -> {
            BillDTO dto = new BillDTO();
            dto.setId(bill.getId());
            dto.setCustomerId(bill.getCustomer().getId());
            dto.setCustomerName(bill.getCustomer().getName());
            dto.setCustomerAccountNumber(bill.getCustomer().getAccountNumber());
            dto.setUnitsConsumed(bill.getUnitsConsumed());
            dto.setTotalAmount(bill.getTotalAmount());
            dto.setBillDate(bill.getBillDate());
            return dto;
        }).collect(Collectors.toList());
    }

    private double calculateTotalAmount(int unitsConsumed) {
        return unitsConsumed * 10.0;
    }
}
