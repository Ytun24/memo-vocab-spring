package com.example.memovocab.controller;

import com.example.memovocab.entity.User;
import com.example.memovocab.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/user")
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
    public Optional<User> getUserById(@PathVariable("id") Integer id) {
        log.info("Get User by {}", id);
        return userService.getUser(id);
    }

}
