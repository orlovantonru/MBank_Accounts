package com.minibank.mbank_accounts.rest;

import com.minibank.mbank_accounts.model.Account;
import com.minibank.mbank_accounts.service.AccountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")

public class AccountRestControllerV1 {

    AccountService accountService;

    @Value("${featire_flags.account_create}")
    private String featire_flags_account_create;

    @Value("${featire_flags.account_get_by_user}")
    private String featire_flags_account_get_by_user;

    @Value("${featire_flags.account_save}")
    private String featire_flags_account_save;

    public AccountRestControllerV1(AccountService accountService) {

        this.accountService = accountService;

    }

    @GetMapping("/account/{userId}")
    public List<Account> getAccountByUserDetails(@PathVariable("userId") Long userId) {
        return accountService.findByUserId(userId);
    }

    @PostMapping("/account/")
    public String createAccountDetails(@RequestBody Account account)
    {
        if (featire_flags_account_create.equals("0")) {
            return null;
        }
        accountService.saveAccount (account);
        return "Account Created Successfully";
    }

    @PutMapping("/account/")
    public String saveAccountDetails(@RequestBody Account account)
    {
        if (featire_flags_account_save.equals("0")) {
            return null;
        }
        accountService.saveAccount (account);
        return "Account Save Successfully";
    }
}