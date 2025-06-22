package com.example.memovocab.model;

import com.example.memovocab.enums.SortDirection;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sorting {
    @NotBlank
    private String field;

    @NotBlank
    private SortDirection direction;
}
