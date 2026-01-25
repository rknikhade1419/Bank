package com.reljicd.service;

import com.reljicd.model.User;
import java.util.Optional;

/**
 * Service interface for Customer Identity Management.
 */
public interface UserService {

    /**
     * Finds a user by their unique banking username.
     */
    Optional<User> findByUsername(String username);

    /**
     * Finds a user by their registered email address.
     */
    Optional<User> findByEmail(String email);

    /**
     * Secures and saves a new customer to the system.
     * This implementation should handle password hashing and role assignment.
     */
    User saveUser(User user);
}
