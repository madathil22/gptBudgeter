package com.example.budget.repository;

import com.example.budget.entity.Liability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LiabilityRepository extends JpaRepository<Liability, Long> {
}
