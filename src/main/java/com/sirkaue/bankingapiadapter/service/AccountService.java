package com.sirkaue.bankingapiadapter.service;

import com.sirkaue.bankingapiadapter.model.AccountDto;

import java.util.List;

public interface AccountService {
    List<AccountDto> getAllAccounts();

    AccountDto getAccountByNumber(String accountNumber);
}
