package com.example.app.mappers;

import org.springframework.stereotype.Component;

import com.example.app.dtos.UserAccountDto;
import com.example.app.entities.UserAccount;

@Component
public class UserAccountMapper implements Mapper<UserAccount, UserAccountDto> {

    @Override
    public UserAccount fromDto(UserAccountDto dto) {
        throw new UnsupportedOperationException("Unimplemented method 'fromDto'");
    }

    @Override
    public UserAccountDto toDto(UserAccount entity) {
        return UserAccountDto.builder().email(entity.getEmail()).build();
    }
}
