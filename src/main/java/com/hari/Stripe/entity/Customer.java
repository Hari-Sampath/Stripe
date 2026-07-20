package com.hari.Stripe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Your local database ID

    @Column(name = "stripe_customer_id", unique = true, nullable = false)
    private String stripeCustomerId; // Maps to Stripe 'id' (e.g., cus_123456789)

    @Column
    private String name;

    @Column(unique = true)
    private String email;

    @Column
    private String description;

    @Column
    private Long balance;

    @Column
    private String currency;

    @Column
    private Date joinDate;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PaymentMethod> paymentMethods;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaction> transactions;
}