package com.example.memovocab.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paging {
    @NotBlank
    private int pageNumber;

    @NotBlank
    private int pageSize;
}
