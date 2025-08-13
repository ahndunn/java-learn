package com.example.app.dtos;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class JwtRequestDto {
    private String email;
    private String password;
}
