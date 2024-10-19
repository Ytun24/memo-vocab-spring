package com.example.memovocab.service;

import com.example.memovocab.entity.User;
import com.example.memovocab.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> searchUser() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(int id) {
        return userRepository.findById(id);
    }
}
