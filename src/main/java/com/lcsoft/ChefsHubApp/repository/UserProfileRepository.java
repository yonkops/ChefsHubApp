package com.lcsoft.ChefsHubApp.repository;

import com.lcsoft.ChefsHubApp.model.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
