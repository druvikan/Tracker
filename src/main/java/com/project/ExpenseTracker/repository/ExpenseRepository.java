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
public interface ExpenseRepository extends JpaRepository<ExpenseEntity,Long> {
    List<ExpenseEntity> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT SUM(e.amount) FROM ExpenseEntity e")
    Double sumAllAmount();

    Optional<ExpenseEntity> findFirstByOrderByDateDesc();

}
