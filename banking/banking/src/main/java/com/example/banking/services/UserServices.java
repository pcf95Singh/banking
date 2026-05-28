package com.example.banking.services;

import com.example.banking.entity.UserProfile;
import com.example.banking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository repository;


    public List<UserProfile> getAllUsers() {
        return repository.findAll();
    }

    public UserProfile getUserById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    public UserProfile createUser(UserProfile userProfile) {
        return repository.save(userProfile);
    }
}
