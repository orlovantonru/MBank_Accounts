package com.minibank.mbank_accounts.repository;

import com.minibank.mbank_accounts.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByUserId(Long userId);
    }
