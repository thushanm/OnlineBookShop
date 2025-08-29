package com.example.Online.Billing.Symtem.Pahana.Edu.repository;

import com.example.Online.Billing.Symtem.Pahana.Edu.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomerId(Long customerId);
}
