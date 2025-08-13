package com.example.app.misc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class JwtRequest {
    private String username;
    private String password;
}
