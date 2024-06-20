package com.ginying.memovocab.service;

import com.ginying.memovocab.model.UserModel;
import com.ginying.memovocab.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserModel findUserByName(String name) {
        return this.userRepository.findByName(name);
    }

    @Override
    public UserModel findOne(String id) {
        return this.userRepository.findById(id).orElse(null);
    }
}
