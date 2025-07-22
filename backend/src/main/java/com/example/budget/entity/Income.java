package com.example.budget.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    private LocalDate date;

    public Income() {}

    public Income(double amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public Long getId() { return id; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}
