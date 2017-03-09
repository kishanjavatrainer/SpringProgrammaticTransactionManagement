package com.infotech.service;

import com.infotech.model.Account;

public interface BankService {
public abstract void transferFund(Account fromAccount,Account toAccount,Double amount);
}
