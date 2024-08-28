package com.project.ExpenseTracker.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExpenseDTO {
    private String title;
    private String description;
    private String category;
    private LocalDateTime date;
    private Double amount;
}
