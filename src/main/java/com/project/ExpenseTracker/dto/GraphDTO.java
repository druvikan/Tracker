package com.project.ExpenseTracker.dto;

import com.project.ExpenseTracker.entity.ExpenseEntity;
import com.project.ExpenseTracker.entity.IncomeEntity;
import lombok.Data;

import java.util.List;

@Data
public class GraphDTO {
    private List<ExpenseEntity> expenseEntityList;
    private List<IncomeEntity> incomeEntityList;
}
