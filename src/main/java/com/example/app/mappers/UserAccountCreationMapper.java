package com.example.app.mappers;

import org.springframework.stereotype.Component;

import com.example.app.dtos.UserAccountCreationDto;
import com.example.app.entities.UserAccount;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;

@Component
@RequiredArgsConstructor
public class UserAccountCreationMapper implements Mapper<UserAccount, UserAccountCreationDto> {
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserAccount fromDto(UserAccountCreationDto dto) {
        return UserAccount
                .builder()
                .id(null)
                .email(dto.getEmail())
                .passwordHash(passwordEncoder.encode(dto.getPassword()))
                .build();
    }

    @Override
    public UserAccountCreationDto toDto(UserAccount entity) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

}
