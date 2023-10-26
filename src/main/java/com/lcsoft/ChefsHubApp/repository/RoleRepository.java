package com.lcsoft.ChefsHubApp.repository;

import com.lcsoft.ChefsHubApp.model.entity.Role;
import com.lcsoft.ChefsHubApp.model.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleType role);
}
