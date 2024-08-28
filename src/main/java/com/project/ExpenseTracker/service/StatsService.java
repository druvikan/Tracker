package com.project.ExpenseTracker.service;

import com.project.ExpenseTracker.dto.GraphDTO;
import com.project.ExpenseTracker.dto.StatsDTO;

public interface StatsService {
    GraphDTO getGraphData();
    StatsDTO getStats();
}
