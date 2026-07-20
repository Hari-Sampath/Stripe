package com.hari.Stripe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stripe_payment_method_id", unique = true, nullable = false)
    private String stripePaymentMethodId;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "card_brand")
    private String cardBrand;

    @Column(name = "card_last4", length = 4)
    private String cardLast4;

    @Column(name = "exp_month")
    private Long expMonth;

    @Column(name = "exp_year")
    private Long expYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
}