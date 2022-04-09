package com.example.testenglish.repository;

import com.example.testenglish.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}