package com.example.unit_test_practice.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDto {

    @NotBlank
    private Long id;

    @NotBlank
    private String name;
    private String email;
}
