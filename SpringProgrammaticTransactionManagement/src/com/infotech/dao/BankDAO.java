package com.infotech.dao;

import com.infotech.model.Account;

public interface BankDAO {

	public abstract void withdraw(Account fromAccount,Double withdrawAmt);
	public abstract void deposit(Account toAccount,Double depositAmt);
}
