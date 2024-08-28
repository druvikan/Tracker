package com.project.ExpenseTracker.dto;

import com.project.ExpenseTracker.entity.ExpenseEntity;
import com.project.ExpenseTracker.entity.IncomeEntity;
import lombok.Data;

@Data
public class StatsDTO {
    private double totalIncome;
    private double totalExpense;
    private ExpenseEntity latestExpenseEntity;
    private IncomeEntity latestIncomeEntity;
    private double balance;
    private double minExpense;
    private double maxExpense;
    private double minIncome;
    private double maxIncome;


}
