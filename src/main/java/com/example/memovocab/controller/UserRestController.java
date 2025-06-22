package com.example.memovocab.controller;

import com.example.memovocab.exception.NotFoundException;
import com.example.memovocab.model.UserDto;
import com.example.memovocab.model.UserPostRequestDto;
import com.example.memovocab.model.UserPostResponseDto;
import com.example.memovocab.model.UserSearchDto;
import com.example.memovocab.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @PostMapping("/search") public ResponseEntity<List<UserDto>> searchUser(@Valid @RequestBody UserSearchDto searchCriteria) {
        log.info("Search User");
        var result = userService.searchUser(searchCriteria);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}") public UserDto getUserById(@PathVariable("id") Integer userId) {
        log.info("Get User by User ID {}", userId);
        return userService.getUser(userId);
    }

    @PostMapping("/create")
    public ResponseEntity<UserPostResponseDto> createUser(@Valid @RequestBody UserPostRequestDto user) {
        log.info("Create User");
        UserPostResponseDto result = userService.createUser(user);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/{id}") public ResponseEntity<UserPostResponseDto> updateUser(@PathVariable(
            "id") Integer userId, @RequestBody UserPostRequestDto user) {
        log.info("Update User ID {}", userId);
        UserPostResponseDto result = userService.updateUser(userId, user);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserPostResponseDto> replaceUser(@PathVariable Integer userId, @Valid RequestEntity<UserPostRequestDto> requestEntity) throws NotFoundException {
        log.info("Replace User ID {}", userId);
        log.info("{}, {}", requestEntity.getMethod(), requestEntity.getUrl());
        UserPostResponseDto result = userService.replaceUser(userId, requestEntity.getBody());
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{userId}") public ResponseEntity deleteUser(@PathVariable Integer userId) {
        log.info("Delete User ID {}", userId);
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
