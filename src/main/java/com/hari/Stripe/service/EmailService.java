package com.hari.Stripe.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendPaymentFailureEmail(String toEmail, Long amountInCents, String currency) {
        // Convert cents to standard currency format
        double formattedAmount = amountInCents / 100.0;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Action Required: Payment Failed");
        message.setText(
                "Hello,\n\n" +
                        "We were unable to process your recent payment of " + formattedAmount + " " + currency.toUpperCase() + ".\n" +
                        "Please update your payment method to ensure uninterrupted service.\n\n" +
                        "Thank you!"
        );

        try {
            mailSender.send(message);
            System.out.println("Failure email sent to: " + toEmail);
        } catch (Exception e) {
            System.err.println("Failed to send email to " + toEmail + ": " + e.getMessage());
        }
    }
}