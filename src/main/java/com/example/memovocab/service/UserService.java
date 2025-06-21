package com.example.memovocab.service;

import com.example.memovocab.entity.User;
import com.example.memovocab.exception.NotFoundException;
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

    public UserPostResponseDto replaceUser(Integer userId, UserPostRequestDto userReq) throws NotFoundException {
        User updatedUser = userRepository.findById(userId).map(exitingUser -> {
            exitingUser.setUsername(userReq.getUsername());
            exitingUser.setFirstName(userReq.getFirstName());
            exitingUser.setLastName(userReq.getLastName());
            return userRepository.save(exitingUser);
        }).orElseThrow(() -> new NotFoundException("User not found"));

        return UserMapper.INSTANCE.mapToUserPostResponseDto(updatedUser);
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
