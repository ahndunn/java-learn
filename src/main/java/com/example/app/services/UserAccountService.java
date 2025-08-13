package com.example.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.app.dtos.UserAccountCreationDto;
import com.example.app.entities.UserAccount;
import com.example.app.mappers.UserAccountCreationMapper;
import com.example.app.repositories.UserAccountRepository;

@Service
public class UserAccountService implements UserDetailsService {
    @Autowired
    private UserAccountRepository repository;
    @Autowired
    private UserAccountCreationMapper mapper;

    public UserAccount save(UserAccountCreationDto dto) {
        final UserAccount user = mapper.fromDto(dto);
        return repository.save(user);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username).map(UserAccountDetails::new).orElseThrow(
                () -> new UsernameNotFoundException(String.format("User of `email=%s` not found", username)));
    }

}
