package com.project.ExpenseTracker.service;

import com.project.ExpenseTracker.dto.GraphDTO;
import com.project.ExpenseTracker.dto.StatsDTO;
import com.project.ExpenseTracker.entity.ExpenseEntity;
import com.project.ExpenseTracker.entity.IncomeEntity;
import com.project.ExpenseTracker.repository.ExpenseRepository;
import com.project.ExpenseTracker.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {
    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;

    public GraphDTO getGraphData(){

        LocalDateTime endDate=LocalDateTime.now();
        LocalDateTime startDate=endDate.minusDays(30);

        GraphDTO graphDTO=new GraphDTO();
        graphDTO.setExpenseEntityList(expenseRepository.findByDateBetween(startDate,endDate));
        graphDTO.setIncomeEntityList(incomeRepository.findByDateBetween(startDate,endDate));

        return graphDTO;
    }

    public StatsDTO getStats(){

        StatsDTO statsDTO =new StatsDTO();

        statsDTO.setTotalExpense(expenseRepository.sumAllAmount());
        statsDTO.setTotalIncome(incomeRepository.sumAllAmount());

        Optional<ExpenseEntity> optionalExpense= expenseRepository.findFirstByOrderByDateDesc();
        Optional<IncomeEntity> optionalIncome= incomeRepository.findFirstByOrderByDateDesc();

        optionalIncome.ifPresent(statsDTO::setLatestIncomeEntity);
        optionalExpense.ifPresent(statsDTO::setLatestExpenseEntity);

        statsDTO.setBalance(incomeRepository.sumAllAmount()-expenseRepository.sumAllAmount());
        OptionalDouble minExpense= expenseRepository.findAll().stream().mapToDouble(ExpenseEntity::getAmount).min();
        OptionalDouble maxExpense= expenseRepository.findAll().stream().mapToDouble(ExpenseEntity::getAmount).max();
        OptionalDouble minIncome= incomeRepository.findAll().stream().mapToDouble(IncomeEntity::getAmount).min();
        OptionalDouble maxIncome= incomeRepository.findAll().stream().mapToDouble(IncomeEntity::getAmount).max();

        minExpense.ifPresent(statsDTO::setMinExpense);
        minIncome.ifPresent(statsDTO::setMinIncome);
        maxExpense.ifPresent(statsDTO::setMaxExpense);
        maxIncome.ifPresent(statsDTO::setMaxIncome);


        return statsDTO;
    }

}
