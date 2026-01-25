package com.reljicd.repository;

import com.reljicd.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    
    // Finds a specific bank account by its unique Database ID
    Optional<Account> findById(Long id);

    // NEW: Find an account by the actual Bank Account Number (e.g., "ACT-123")
    Optional<Account> findByAccountNumber(String accountNumber);
}
