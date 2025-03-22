package com.example.Expense.Reimbursement.API.Backend.repo;

import com.example.Expense.Reimbursement.API.Backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByUsername(String username);
}
