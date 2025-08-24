package com.example.Online.Billing.Symtem.Pahana.Edu.repository;

import com.example.Online.Billing.Symtem.Pahana.Edu.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
