package com.example.Online.Billing.Symtem.Pahana.Edu.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class BillDTO {
    private Long id;
    private Long customerId;
    private int unitsConsumed;
    private double totalAmount;
    private LocalDate billDate;
}
