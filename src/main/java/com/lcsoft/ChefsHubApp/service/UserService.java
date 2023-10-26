package com.lcsoft.ChefsHubApp.service;

import com.lcsoft.ChefsHubApp.error.RoleNotFoundException;
import com.lcsoft.ChefsHubApp.model.dto.UserProfileDto;
import com.lcsoft.ChefsHubApp.model.dto.UserRegistrationDto;
import com.lcsoft.ChefsHubApp.model.entity.Role;
import com.lcsoft.ChefsHubApp.model.entity.UserProfile;
import com.lcsoft.ChefsHubApp.model.enums.RoleType;
import com.lcsoft.ChefsHubApp.model.entity.User;
import com.lcsoft.ChefsHubApp.repository.RoleRepository;
import com.lcsoft.ChefsHubApp.repository.UserProfileRepository;
import com.lcsoft.ChefsHubApp.repository.UserRepository;
import com.lcsoft.ChefsHubApp.error.UserAlreadyExistsException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

public class UserService {
    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserProfileRepository userProfileRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(UserRegistrationDto registrationDto) {
        if (userRepository.existsByUsername(registrationDto.getUsername())) {
            throw new UserAlreadyExistsException("Username is already in use");
        }
        if (userRepository.existsByEmail(registrationDto.getEmail())) {
            throw new UserAlreadyExistsException("Email is already in use");
        }

        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        userRepository.save(user);

        Role defaultRole = roleRepository.findByName(RoleType.COMMON_USER)
                .orElseThrow(() -> new RoleNotFoundException("Default role not found"));
        user.setRole(Collections.singleton(defaultRole));

        return user;
    }

    public UserProfile updateUserProfile(UserProfile user, UserProfileDto profileDto) {
        user.setFirstName(profileDto.getFirstName());
        user.setLastName(profileDto.getLastName());
        userProfileRepository.save(user);
        return user;
    }

   /* public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                getAuthorities(user.getRoles())
        );
    }

    private Set<GrantedAuthority> getAuthorities(Set<Role> roles) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName().toString()));
        return authorities;
    }*/


}
