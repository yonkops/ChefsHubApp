package com.lcsoft.ChefsHubApp.model.repository;

import com.lcsoft.ChefsHubApp.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);


    boolean existsByEmail(String email);
}
