package com.reljicd.model;

import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private Long id;

    @Column(name = "account_type", nullable = false)
    @Length(min = 3, message = "*Account type must have at least 3 characters (e.g., Savings)")
    private String accountType;

    @Column(name = "description")
    private String description;

    @Column(name = "account_number", nullable = false, unique = true)
    @NotNull(message = "*Account number is required")
    private String accountNumber;

    @Column(name = "balance", nullable = false)
    @DecimalMin(value = "0.00", message = "*Balance cannot be negative")
    private BigDecimal balance;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id.equals(account.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
