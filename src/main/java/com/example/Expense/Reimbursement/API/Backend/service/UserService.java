package com.example.Expense.Reimbursement.API.Backend.service;

import com.example.Expense.Reimbursement.API.Backend.model.User;
import com.example.Expense.Reimbursement.API.Backend.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public User save(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);

    }
}
