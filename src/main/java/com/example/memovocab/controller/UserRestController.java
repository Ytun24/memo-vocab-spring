package com.example.memovocab.controller;

import com.example.memovocab.entity.User;
import com.example.memovocab.model.UserPostRequestDto;
import com.example.memovocab.model.UserPostResponseDto;
import com.example.memovocab.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @PostMapping("/search")
    public ResponseEntity<List<User>> searchUser() {
        log.info("Search User");
        var result = userService.searchUser();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") Integer userId) {
        log.info("Get User by User ID {}", userId);
        return userService.getUser(userId);
    }

    @PostMapping("/create")
    public ResponseEntity<UserPostResponseDto> createUser(@RequestBody UserPostRequestDto user) {
        log.info("Create User");
        UserPostResponseDto result = userService.createUser(user);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserPostResponseDto> updateUser(@PathVariable("id") Integer userId, @RequestBody UserPostRequestDto user) {
        log.info("Update User ID {}", userId);
        UserPostResponseDto result = userService.updateUser(userId, user);
        return ResponseEntity.ok(result);
    }

}
