package com.example.memovocab.service;

import com.example.memovocab.entity.User;
import com.example.memovocab.mapper.UserMapper;
import com.example.memovocab.model.UserPostRequestDto;
import com.example.memovocab.model.UserPostResponseDto;
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

    public UserPostResponseDto createUser(UserPostRequestDto userReq) {
        User user = UserMapper.INSTANCE.mapToUser(userReq);
        return UserMapper.INSTANCE.mapToUserPostResponseDto(userRepository.save(user));
    }

    public UserPostResponseDto updateUser(Integer userId, UserPostRequestDto userReq) {
        User user = getUser(userId).get();
        UserMapper.INSTANCE.updateUserFromDto(userReq, user);
        return UserMapper.INSTANCE.mapToUserPostResponseDto(userRepository.save(user));
    }
}
