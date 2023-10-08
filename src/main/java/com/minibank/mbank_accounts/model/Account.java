package com.minibank.mbank_accounts.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Account {

    private Long id;
    private String accountNumber;
    private Date accountDate;
    private Long userId;
    private Float percent;
    private Float saldo;
}

