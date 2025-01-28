package com.sirkaue.bankingapiadapter.controller;

import com.sirkaue.bankingapiadapter.service.AccountService;
import com.sirkaue.bankingapiadapter.model.ExternalAccountDetailsDto;
import com.sirkaue.bankingapiadapter.adapter.ExternalBankingAdapter;
import com.sirkaue.bankingapiadapter.model.AccountDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;
    private final ExternalBankingAdapter externalBankingAdapter;

    public AccountController(AccountService accountService, ExternalBankingAdapter externalBankingAdapter) {
        this.accountService = accountService;
        this.externalBankingAdapter = externalBankingAdapter;
    }

    @GetMapping
    public List<AccountDto> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{accountNumber}")
    public AccountDto getAccount(@PathVariable String accountNumber) {
        return accountService.getAccountByNumber(accountNumber);
    }

    @GetMapping("/{accountNumber}/external")
    public ExternalAccountDetailsDto getExternalAccountDetails(@PathVariable String accountNumber) {
        return externalBankingAdapter.fetchAccountDetails(accountNumber);
    }
}
