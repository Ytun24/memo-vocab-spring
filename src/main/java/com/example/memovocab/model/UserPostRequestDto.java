package com.example.memovocab.model;

import com.example.memovocab.entity.UserPreferences;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPostRequestDto {
    @NotBlank(message = "Firstname must not be blank")
    private String firstName;

    @NotBlank(message = "Lastname must not be blank")
    private String lastName;

    @NotBlank(message = "Username must not be blank")
    private String username;

    private UserPreferences preference;
}
