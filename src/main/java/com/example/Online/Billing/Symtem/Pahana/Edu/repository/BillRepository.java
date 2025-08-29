package com.example.Online.Billing.Symtem.Pahana.Edu.repository;

import com.example.Online.Billing.Symtem.Pahana.Edu.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findByCustomerId(Long customerId);
}
