package com.lcsoft.ChefsHubApp.service.impl;

import com.lcsoft.ChefsHubApp.model.entity.Role;
import com.lcsoft.ChefsHubApp.model.entity.UserEntity;
import com.lcsoft.ChefsHubApp.model.enums.RoleType;
import com.lcsoft.ChefsHubApp.model.repository.UserRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomUserDetailsService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity == null) {
            throw new UsernameNotFoundException("User " + email + " not found!");
        }
        userEntity.setLastLoginDate(LocalDate.now());
        userRepository.saveAndFlush(userEntity);
        return map(userEntity);
    }

    private static UserDetails map(UserEntity userEntity) {
        return User
                .withUsername(userEntity.getEmail())
                .password(userEntity.getPassword())
                .authorities(userEntity.getFirstName())
                .authorities(userEntity.getLastName())
                .authorities(userEntity.getRoles().stream().map(CustomUserDetailsService::map).toList())
                .build();
    }

    private static GrantedAuthority map(Role role) {
        return new SimpleGrantedAuthority(
                "ROLE_" + role.getName().name()
        );
    }

    public void configureAuthenticationManagerBuilder(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this)
                .passwordEncoder(passwordEncoder);
    }
}
