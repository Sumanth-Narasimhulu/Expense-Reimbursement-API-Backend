package com.example.Expense.Reimbursement.API.Backend.controller;

import com.example.Expense.Reimbursement.API.Backend.model.Expense;
import com.example.Expense.Reimbursement.API.Backend.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;
//    Employee submit an expense
    @PostMapping("/submit")
    public Expense submitExpense(@RequestBody Expense expense) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        expense.setSubmittedBy(username);
        expense.setSubmittedAt(LocalDateTime.now());
        expense.setStatus("SUBMITTED");
        return expenseService.save(expense);
    }

    @PostMapping("/approve/{expenseId}")
    public Expense approveExpense(@PathVariable Long expenseId,
                                  @RequestParam String decision,
                                  @RequestParam String managerComment){
        Expense expense = expenseService.findById(expenseId);
        if(expense==null)throw new RuntimeException("Expense not found");
        expense.setStatus(decision);
        expense.setManagerComment(managerComment);
        return expenseService.save(expense);
    }
    @PostMapping("/process/{expenseId}")
    public Expense processExpense(@PathVariable Long expenseId){
        Expense expense = expenseService.findById(expenseId);
        if(expense==null)throw new RuntimeException("Expense not found");
        expense.setStatus("Processed");
        return expenseService.save(expense);
    }

}
