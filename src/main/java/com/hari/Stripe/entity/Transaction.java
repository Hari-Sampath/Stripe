package com.hari.Stripe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stripe_payment_intent_id", unique = true, nullable = false)
    private String stripePaymentIntentId; // Maps to Stripe 'id' (e.g., pi_123456789)

    @Column(nullable = false)
    private Long amount;

    @Column(nullable = false)
    private String currency;

    @Column(nullable = false)
    private String status;

    @Column(name = "latest_charge_id")
    private String latestChargeId;

    @Column
    private Date created;

    @Column(name = "error_code")
    private String errorCode;

    @Column(name = "failure_alert_sent", nullable = false)
    private boolean failureAlertSent = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_method_entity_id")
    private PaymentMethod paymentMethod;
}