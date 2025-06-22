package com.example.memovocab.model;

import com.example.memovocab.entity.UserPreferences;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class UserDto {
    private String firstName;
    private String lastName;
    private String username;
    private UserPreferences userPreferences;
    private List<FavoritesDto> favorites;
    private Set<VocabDto> vocabularies;
}
