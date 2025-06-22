package com.example.memovocab.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSearchDto {
    private SelectCriteria selectField;

    @NotNull
    private Sorting sorting;

    @NotNull
    private Paging paging;
}
