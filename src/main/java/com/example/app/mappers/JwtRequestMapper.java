package com.example.app.mappers;

import org.springframework.stereotype.Component;

import com.example.app.dtos.JwtRequestDto;
import com.example.app.misc.JwtRequest;

@Component
public class JwtRequestMapper implements Mapper<JwtRequest, JwtRequestDto> {
    @Override
    public JwtRequest fromDto(JwtRequestDto dto) {
        return JwtRequest.builder().username(dto.getEmail()).password(dto.getPassword()).build();
    }

    @Override
    public JwtRequestDto toDto(JwtRequest entity) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

}
