package com.example.expense.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.expense.entity.ReportDTO;
import com.example.expense.services.TransactionService;
@CrossOrigin("*")
@RestController
public class ReportController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/report")
    public String showReportForm() {
        return "report";
    }

    @PostMapping("/report")
    public List<Object[]> generateReport(@RequestBody ReportDTO  report) {
        LocalDate fromDate = LocalDate.parse(report.getFromDate());
        LocalDate toDate = LocalDate.parse(report.getToDate());
        List<Object[]> transactions = transactionService.getTransactionReport(fromDate, toDate);
        
        return transactions;
    }


}
