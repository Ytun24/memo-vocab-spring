package com.ginying.memovocab.controller;

import com.ginying.memovocab.model.UserModel;
import com.ginying.memovocab.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public UserModel getUser(@RequestParam String name) {
        return this.userService.findUserByName(name);
    }

    @GetMapping("/{id}")
    public UserModel getUserById(@PathVariable("id") String id) {
        return this.userService.findOne(id);
    }
}
