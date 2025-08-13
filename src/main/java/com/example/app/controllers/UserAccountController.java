package com.example.app.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.dtos.UserAccountCreationDto;
import com.example.app.services.UserAccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserAccountController {
    private final UserAccountService userAccountService;

    @PostMapping
    public Long save(@RequestBody UserAccountCreationDto dto) {
        return userAccountService.save(dto).getId();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userAccountService.deleteById(id);
    }
}
