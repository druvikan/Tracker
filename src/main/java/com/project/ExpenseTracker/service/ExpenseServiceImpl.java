package com.project.ExpenseTracker.service;

import com.project.ExpenseTracker.dto.ExpenseDTO;
import com.project.ExpenseTracker.entity.ExpenseEntity;
import com.project.ExpenseTracker.repository.ExpenseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseEntity postExpense(ExpenseDTO expenseDTO){
        return saveDTO(new ExpenseEntity(),expenseDTO);
    }

    private ExpenseEntity saveDTO(ExpenseEntity expenseEntity, ExpenseDTO expenseDTO){
        expenseEntity.setTitle(expenseDTO.getTitle());
        expenseEntity.setDescription(expenseDTO.getDescription());
        expenseEntity.setCategory(expenseDTO.getCategory());
        expenseEntity.setDate(LocalDateTime.now());
        expenseEntity.setAmount(expenseDTO.getAmount());
        return expenseRepository.save(expenseEntity);
    }

    public List<ExpenseEntity> getAllExpense(){
        return expenseRepository.findAll()
                .stream()
                .sorted(Comparator
                        .comparing(ExpenseEntity::getDate)
                        .reversed())
                .collect(Collectors.toList());
    }

    public ExpenseEntity getExpenseById(Long id){
        return expenseRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Expense is not present for ID " + id));

    }

    public ExpenseEntity updateExpense(Long id,ExpenseDTO expenseDTO){
            return expenseRepository.findById(id)
                    .map(expense->saveDTO(expense,expenseDTO))
                    .orElseThrow(()->new EntityNotFoundException("Expense is not present for ID " + id));

    }

    public void deleteExpense(Long id){
        expenseRepository.findById(id)
                .ifPresentOrElse(expense ->expenseRepository.deleteById(id),
                        () -> {throw new EntityNotFoundException("Expense is not present for ID " + id);}
                );

    }

}
