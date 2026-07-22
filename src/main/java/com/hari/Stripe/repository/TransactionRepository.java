package com.hari.Stripe.repository;

import com.hari.Stripe.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Optional<Transaction> findByStripePaymentIntentId(String stripePaymentIntentId);

    List<Transaction> findByStatusAndFailureAlertSentFalse(String status);

}
