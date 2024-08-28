package com.project.ExpenseTracker.controller;

import com.project.ExpenseTracker.dto.IncomeDTO;
import com.project.ExpenseTracker.entity.ExpenseEntity;
import com.project.ExpenseTracker.entity.IncomeEntity;
import com.project.ExpenseTracker.service.IncomeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/income")
@CrossOrigin("*")
@RequiredArgsConstructor
public class IncomeController {
    private final IncomeService incomeService;

    @PostMapping
    public ResponseEntity<?> postIncome(@RequestBody IncomeDTO incomeDTO){
        IncomeEntity createdIncome = incomeService.postIncome(incomeDTO);
        return Optional.ofNullable(createdIncome)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.badRequest().build());
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllIncome(){
        return ResponseEntity.ok(incomeService.getAllIncome());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getIncomeById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(incomeService.getIncomeById(id));
        }
        catch(EntityNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
        catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateIncome(@PathVariable Long id,@RequestBody IncomeDTO incomeDTO){
        try {
            return ResponseEntity.ok(incomeService.updateIncomeById(id,incomeDTO));
        }
        catch(EntityNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
        catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletedIncome(@PathVariable Long id){
        try {
            incomeService.deletedIncomeById(id);
            return ResponseEntity.ok(null);
        }
        catch(EntityNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
        catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }



}
