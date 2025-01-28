package com.sirkaue.bankingapiadapter.adapter;

import com.sirkaue.bankingapiadapter.service.AccountService;
import com.sirkaue.bankingapiadapter.model.AccountDto;
import com.sirkaue.bankingapiadapter.model.ExternalAccountDetailsDto;
import org.springframework.stereotype.Service;

@Service
public class ExternalBankingAdapterImpl implements ExternalBankingAdapter {

    private final AccountService accountService;

    public ExternalBankingAdapterImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public ExternalAccountDetailsDto fetchAccountDetails(String accountNumber) {
        // Aqui, você recupera a conta local (mock) para simulação
        AccountDto localAccount = accountService.getAccountByNumber(accountNumber);

        if (localAccount != null) {
            // Criando e retornando o ExternalAccountDetailsDto (usando o record)
            return new ExternalAccountDetailsDto(
                    localAccount.accountHolderName(),
                    localAccount.balance(),
                    true,  // Conta ativada
                    "checking",  // Tipo da conta
                    "2024-01-01", // Última transação
                    "active",  // Status da conta
                    "001",  // Código da agência
                    "BRL",  // Moeda
                    1000.0,  // Limite de cheque especial
                    "2020-01-01", // Data de criação
                    false  // Conta não bloqueada
            );
        }

        // Caso a conta não seja encontrada, retornamos um DTO com dados padrão
        return new ExternalAccountDetailsDto(
                "Unknown Holder",
                0.0,
                false,
                "savings",
                "N/A",
                "inactive",
                "000",
                "BRL",
                0.0,
                "N/A",
                true
        );
    }
}
