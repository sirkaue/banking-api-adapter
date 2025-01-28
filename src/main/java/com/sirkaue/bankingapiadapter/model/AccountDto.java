package com.sirkaue.bankingapiadapter.model;

public record AccountDto(
        String accountNumber,
        String accountHolderName,
        double balance) {
}
