package com.project.ExpenseTracker.repository;

import com.project.ExpenseTracker.entity.ExpenseEntity;
import com.project.ExpenseTracker.entity.IncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface IncomeRepository extends JpaRepository<IncomeEntity, Long> {
    List<IncomeEntity> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT SUM(amount) FROM IncomeEntity")
    Double sumAllAmount();
    Optional<IncomeEntity> findFirstByOrderByDateDesc();
}
