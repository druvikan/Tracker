package com.project.ExpenseTracker.controller;

import com.project.ExpenseTracker.dto.GraphDTO;
import com.project.ExpenseTracker.service.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stats")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StatsController {
    private final StatsService statsService;

    @GetMapping("/graph")
    public ResponseEntity<?> getGraphData(){
        return ResponseEntity.ok(statsService.getGraphData());
    }

    @GetMapping("/total")
    public ResponseEntity<?> getStatsData(){
        return ResponseEntity.ok(statsService.getStats());
    }
}
