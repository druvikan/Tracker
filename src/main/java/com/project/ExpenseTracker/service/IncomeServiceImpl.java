package com.project.ExpenseTracker.service;

import com.project.ExpenseTracker.dto.IncomeDTO;
import com.project.ExpenseTracker.entity.IncomeEntity;
import com.project.ExpenseTracker.repository.IncomeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository incomeRepository;

    public IncomeEntity postIncome(IncomeDTO incomeDTO) {
        return save(incomeDTO, new IncomeEntity());
    }

    private IncomeEntity save(IncomeDTO incomeDTO, IncomeEntity incomeEntity) {
        incomeEntity.setTitle(incomeDTO.getTitle());
        incomeEntity.setDescription(incomeDTO.getDescription());
        incomeEntity.setCategory(incomeDTO.getCategory());
        incomeEntity.setDate(LocalDateTime.now());
        incomeEntity.setAmount(incomeDTO.getAmount());
        return incomeRepository.save(incomeEntity);
    }

    public List<IncomeEntity> getAllIncome() {
        return incomeRepository.findAll()
                .stream()
                .sorted(Comparator
                        .comparing(IncomeEntity::getDate)
                        .reversed()
                )
                .collect(Collectors.toList());
    }

    public IncomeEntity getIncomeById(Long id) {
        return incomeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Income does not  exists with id" + id));
    }

    public IncomeEntity updateIncomeById(Long id, IncomeDTO incomeDTO) {
        return incomeRepository.findById(id)
                .map(income -> save(incomeDTO, income))
                .orElseThrow(() -> new EntityNotFoundException("Income does not  exists with id" + id));
    }

    public void deletedIncomeById(Long id) {
         incomeRepository.findById(id)
                .ifPresentOrElse(income -> incomeRepository.deleteById(id),
                        () -> {throw new EntityNotFoundException("Income does not  exists with id" + id);}
                );
    }
}
