package com.sirkaue.bankingapiadapter.adapter;

import com.sirkaue.bankingapiadapter.model.ExternalAccountDetailsDto;

public interface ExternalBankingAdapter {
    ExternalAccountDetailsDto fetchAccountDetails(String accountNumber);
}
