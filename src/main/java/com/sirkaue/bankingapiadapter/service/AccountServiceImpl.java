package com.sirkaue.bankingapiadapter.service;

import com.sirkaue.bankingapiadapter.model.AccountDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
    private final List<AccountDto> accounts = new ArrayList<>();

    public AccountServiceImpl() {
        accounts.add(new AccountDto("123", "John Doe", 1000.0));
        accounts.add(new AccountDto("456", "Jane Smith", 2500.0));
        logger.info("AccountServiceImpl initialized with {} accounts", accounts.size());
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        logger.info("Fetching all accounts");
        return accounts;
    }

    @Override
    public AccountDto getAccountByNumber(String accountNumber) {
        logger.info("Fetching account with number: {}", accountNumber);
        return accounts.stream()
                .filter(account -> account.accountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow(() -> {
                    logger.warn("Account not found for number: {}", accountNumber);
                    return new RuntimeException("Account not found");
                });
    }
}
