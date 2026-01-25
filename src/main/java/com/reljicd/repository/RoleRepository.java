package com.reljicd.repository;

import com.reljicd.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // Finds a role by its name (e.g., "ROLE_USER" or "ROLE_ADMIN")
    Role findByRole(String role);
}
