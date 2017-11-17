package com.jam.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jam.models.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByName(String username);
}
