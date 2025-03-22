package com.example.Expense.Reimbursement.API.Backend.service;

import com.example.Expense.Reimbursement.API.Backend.model.Expense;
import com.example.Expense.Reimbursement.API.Backend.repo.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense findById(Long expenseId) {
        // Throws an exception if expense is not found
        return expenseRepository.findById(expenseId)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + expenseId));
    }

    public Expense save(Expense expense) {
        return expenseRepository.save(expense);
    }
}
