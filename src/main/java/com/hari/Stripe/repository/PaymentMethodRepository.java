package com.hari.Stripe.repository;

import com.hari.Stripe.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentMethodRepository extends JpaRepository <PaymentMethod, Long> {

    Optional<PaymentMethod> findByCustomer_Id(Long customerId);

    Optional<PaymentMethod> findByStripePaymentMethodId(String stripePaymentMethodId);
}
