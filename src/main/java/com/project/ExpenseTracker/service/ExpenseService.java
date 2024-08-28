package com.project.ExpenseTracker.service;

import com.project.ExpenseTracker.dto.ExpenseDTO;
import com.project.ExpenseTracker.entity.ExpenseEntity;

import java.util.List;

public interface ExpenseService {
    ExpenseEntity postExpense(ExpenseDTO expenseDTO);
    List<ExpenseEntity> getAllExpense();
    ExpenseEntity getExpenseById(Long id);
    ExpenseEntity updateExpense(Long id,ExpenseDTO expenseDTO);
    void deleteExpense(Long id);
}
