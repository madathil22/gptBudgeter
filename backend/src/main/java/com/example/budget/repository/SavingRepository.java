package com.example.budget.repository;

import com.example.budget.entity.Saving;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingRepository extends JpaRepository<Saving, Long> {
}
