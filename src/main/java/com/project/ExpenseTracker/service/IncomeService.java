package com.project.ExpenseTracker.service;

import com.project.ExpenseTracker.dto.IncomeDTO;
import com.project.ExpenseTracker.entity.IncomeEntity;

import java.util.List;

public interface IncomeService {
    IncomeEntity postIncome(IncomeDTO incomeDTO);
    List<IncomeEntity> getAllIncome();
    IncomeEntity getIncomeById(Long id);
    IncomeEntity updateIncomeById(Long id,IncomeDTO incomeDTO);
    void deletedIncomeById(Long id);
}
