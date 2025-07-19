package com.example.memovocab.controller;

import com.example.memovocab.entity.AuthUser;
import com.example.memovocab.repository.AuthUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j @RestController @RequestMapping("/auth-users") @RequiredArgsConstructor public class UserAuthRestController {

    private final PasswordEncoder passwordEncoder;
    private final AuthUserRepository authUserRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody AuthUser user) {
        String hashPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);
        authUserRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully registered");
    }

    @GetMapping
    public AuthUser getUserDetailsAfterLogin(Authentication authentication) {
        Optional<AuthUser> authUserOpt = authUserRepository.findByUsername(authentication.getName());
        return authUserOpt.orElse(null);
    }
}
