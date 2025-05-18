package com.example.memovocab.model;

import com.example.memovocab.entity.UserPreferences;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPostResponseDto {
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private UserPreferences userPreferences;
}
