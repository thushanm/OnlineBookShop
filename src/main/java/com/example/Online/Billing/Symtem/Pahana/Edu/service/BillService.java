package com.example.Online.Billing.Symtem.Pahana.Edu.service;

import com.example.Online.Billing.Symtem.Pahana.Edu.dto.BillDTO;
import java.util.List;

public interface BillService {
    void createAndSaveBill(BillDTO billDTO);
    // Add this method
    List<BillDTO> getAllBills();
}
