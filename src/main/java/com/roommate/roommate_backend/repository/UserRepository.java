package com.roommate.roommate_backend.repository;

import com.roommate.roommate_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
} 