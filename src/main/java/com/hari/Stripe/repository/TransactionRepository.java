package com.hari.Stripe.repository;

import com.hari.Stripe.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Optional<Transaction> findByCustomer_Id(Long customerId);

    Optional<Transaction> findById(Long id);

}
