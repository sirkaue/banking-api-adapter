package com.sirkaue.bankingapiadapter.model;

public record ExternalAccountDetailsDto(
        String accountHolder,
        double balance,
        boolean isActivated,  // Conta ativada
        String accountType,   // Tipo da conta (ex: corrente, poupança)
        String lastTransactionDate, // Última transação
        String accountStatus, // Status da conta (ex: ativa, inativa)
        String branchCode,    // Código da agência
        String currency,      // Moeda (ex: BRL)
        double overdraftLimit, // Limite de cheque especial
        String creationDate,  // Data de criação da conta
        boolean isBlocked     // Se a conta está bloqueada
) {
}
