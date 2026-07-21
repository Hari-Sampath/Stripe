package com.hari.Stripe.config;

import com.stripe.Stripe;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StripeConfig {

    @Value("${stripe.api.key}")
    private String stripeApiKey;

    @PostConstruct
    public void setupStripe() {
        // This injects your secret key into the Stripe SDK on startup
        Stripe.apiKey = stripeApiKey;
    }
}