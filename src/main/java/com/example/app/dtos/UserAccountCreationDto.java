package com.example.app.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class UserAccountCreationDto {
    private final String email;
    private final String password;
}
