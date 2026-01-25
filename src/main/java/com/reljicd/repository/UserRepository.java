package com.reljicd.repository;

import com.reljicd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Used for unique identification during login and password recovery
    Optional<User> findByEmail(String email);

    // Used by Spring Security's UserDetailsService to load user details
    Optional<User> findByUsername(String username);
}
