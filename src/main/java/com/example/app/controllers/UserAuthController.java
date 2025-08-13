package com.example.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.dtos.JwtRequestDto;
import com.example.app.mappers.JwtRequestMapper;
import com.example.app.misc.JwtRequest;
import com.example.app.services.JwtService;

@RestController
@RequestMapping("/users/auth")
public class UserAuthController {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    JwtRequestMapper mapper;

    @PostMapping()
    public String authenticateAndGetToken(@RequestBody JwtRequestDto dto) {
        JwtRequest jwtRequest = mapper.fromDto(dto);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(jwtRequest.getUsername());
        }
        throw new UsernameNotFoundException("Invalid user request");
    }
}
