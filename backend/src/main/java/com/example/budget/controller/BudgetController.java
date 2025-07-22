package com.example.budget.controller;

import com.example.budget.entity.*;
import com.example.budget.repository.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class BudgetController {

    @Autowired
    private IncomeRepository incomeRepo;
    @Autowired
    private LiabilityRepository liabilityRepo;
    @Autowired
    private CreditCardPaymentRepository cardRepo;
    @Autowired
    private SavingRepository savingRepo;

    @PostMapping("/income")
    public Income addIncome(@RequestBody Income income) {
        return incomeRepo.save(income);
    }

    @PostMapping("/liability")
    public Liability addLiability(@RequestBody Liability liability) {
        return liabilityRepo.save(liability);
    }

    @PostMapping("/credit-card")
    public CreditCardPayment addCard(@RequestBody CreditCardPayment payment) {
        return cardRepo.save(payment);
    }

    @PostMapping("/savings")
    public Saving setSavings(@RequestBody Saving saving) {
        savingRepo.deleteAll();
        return savingRepo.save(saving);
    }

    @GetMapping("/summary")
    public Summary getSummary() {
        double totalIncome = incomeRepo.findAll().stream().mapToDouble(Income::getAmount).sum();
        double totalLiabilities = liabilityRepo.findAll().stream().mapToDouble(Liability::getAmount).sum();
        double totalCards = cardRepo.findAll().stream().mapToDouble(CreditCardPayment::getAmount).sum();
        double savings = savingRepo.findAll().stream().mapToDouble(Saving::getAmount).sum();
        double remaining = totalIncome - totalLiabilities - totalCards - savings;
        return new Summary(totalIncome, totalLiabilities, totalCards, savings, remaining);
    }

    public record Summary(double totalIncome, double totalLiabilities, double totalCards, double savings, double remaining) {}
}
