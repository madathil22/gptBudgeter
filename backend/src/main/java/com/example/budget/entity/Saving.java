package com.example.budget.entity;

import jakarta.persistence.*;

@Entity
public class Saving {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;

    public Saving() {}

    public Saving(double amount) {
        this.amount = amount;
    }

    public Long getId() { return id; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}
