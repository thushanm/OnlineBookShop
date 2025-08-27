package com.example.Online.Billing.Symtem.Pahana.Edu.repository;

import com.example.Online.Billing.Symtem.Pahana.Edu.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
}
