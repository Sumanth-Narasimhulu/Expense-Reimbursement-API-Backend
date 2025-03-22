package com.example.Expense.Reimbursement.API.Backend.repo;

import com.example.Expense.Reimbursement.API.Backend.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    List<Expense>findBySubmittedBy(String username);
//    Optional<Expense> findById(Long expenseId);
}
