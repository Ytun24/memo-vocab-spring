package com.example.memovocab.service;

import com.example.memovocab.entity.User;
import com.example.memovocab.mapper.UserMapper;
import com.example.memovocab.model.UserDto;
import com.example.memovocab.model.UserPostRequestDto;
import com.example.memovocab.model.UserPostResponseDto;
import com.example.memovocab.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> searchUser() {
        return userRepository.findAll();
    }

    public UserDto getUser(int id) {
        User user = userRepository.findById(id).get();
        return UserMapper.INSTANCE.mapToUserDto(user);
    }

    public UserPostResponseDto createUser(UserPostRequestDto userReq) {
        User user = UserMapper.INSTANCE.mapToUser(userReq);
        return UserMapper.INSTANCE.mapToUserPostResponseDto(userRepository.save(user));
    }

    public UserPostResponseDto updateUser(Integer userId, UserPostRequestDto userReq) {
        User user = userRepository.findById(userId).get();
        UserMapper.INSTANCE.updateUserFromDto(userReq, user);
        return UserMapper.INSTANCE.mapToUserPostResponseDto(userRepository.save(user));
    }
}
