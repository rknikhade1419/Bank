package com.reljicd.repository;

import com.reljicd.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    
    Optional<Account> findByAccountNumber(String accountNumber);
    
    boolean existsByAccountNumber(String accountNumber);
    
    // Explicitly declare these methods
    @Override
    Optional<Account> findById(Long id);
    
    @Override
    void deleteById(Long id);
}
