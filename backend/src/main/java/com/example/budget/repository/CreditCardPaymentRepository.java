package com.example.budget.repository;

import com.example.budget.entity.CreditCardPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardPaymentRepository extends JpaRepository<CreditCardPayment, Long> {
}
