package com.example.budget.entity;

import jakarta.persistence.*;

@Entity
public class Liability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double amount;

    public Liability() {}

    public Liability(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}
