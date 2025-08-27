package com.example.Online.Billing.Symtem.Pahana.Edu.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private Long customerId;
    private String customerName;
    private LocalDate orderDate;
    private double totalAmount;
    private List<Long> itemIds;
    private List<Integer> quantities;
}
