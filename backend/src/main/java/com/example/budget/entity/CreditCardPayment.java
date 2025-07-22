package com.example.budget.entity;

import jakarta.persistence.*;

@Entity
public class CreditCardPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardName;
    private double amount;

    public CreditCardPayment() {}

    public CreditCardPayment(String cardName, double amount) {
        this.cardName = cardName;
        this.amount = amount;
    }

    public Long getId() { return id; }
    public String getCardName() { return cardName; }
    public void setCardName(String cardName) { this.cardName = cardName; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}
