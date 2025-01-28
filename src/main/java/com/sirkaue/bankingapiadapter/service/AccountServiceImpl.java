package com.sirkaue.bankingapiadapter.service;

import com.sirkaue.bankingapiadapter.model.AccountDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final List<AccountDto> accounts = new ArrayList<>();

    public AccountServiceImpl() {
        accounts.add(new AccountDto("123", "John Doe", 1000.0));
        accounts.add(new AccountDto("456", "Jane Smith", 2500.0));
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        return accounts;
    }

    @Override
    public AccountDto getAccountByNumber(String accountNumber) {
        return accounts.stream()
                .filter(account -> account.accountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }
}
