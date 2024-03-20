package com.example.mailspring.models.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class PersonRegistrationDto {
    private String username;
    private String password;
    private Integer age;
}
