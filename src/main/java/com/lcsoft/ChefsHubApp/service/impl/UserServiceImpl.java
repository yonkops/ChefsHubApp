package com.lcsoft.ChefsHubApp.service.impl;

import com.lcsoft.ChefsHubApp.model.dto.UserRegistrationDto;
import com.lcsoft.ChefsHubApp.model.entity.Role;
import com.lcsoft.ChefsHubApp.model.entity.UserEntity;
import com.lcsoft.ChefsHubApp.model.enums.RoleType;
import com.lcsoft.ChefsHubApp.model.repository.RoleRepository;
import com.lcsoft.ChefsHubApp.model.repository.UserRepository;
import com.lcsoft.ChefsHubApp.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(UserRegistrationDto userRegistrationDto) {
        userRepository.save(map(userRegistrationDto));
    }


    private UserEntity map(UserRegistrationDto userRegistrationDto) {

        Role defaultRole = roleRepository.findByName(RoleType.COMMON_USER).orElseThrow(() -> new RuntimeException("Role not found"));
        return new UserEntity()
        .setFirstName(userRegistrationDto.firstName())
        .setLastName(userRegistrationDto.lastName())
        .setEmail(userRegistrationDto.email())
        .setPassword(passwordEncoder.encode(userRegistrationDto.password()))
        .setCreationDate(LocalDate.now())
        .setRoles(Collections.singleton(defaultRole));
    }

}
