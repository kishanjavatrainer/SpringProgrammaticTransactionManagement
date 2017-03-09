package com.infotech.serviceImpl;


import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.infotech.dao.BankDAO;
import com.infotech.model.Account;
import com.infotech.service.BankService;

public class BankServiceImpl implements BankService {

	private BankDAO bankDAO;
	private TransactionTemplate transactionTemplate;
	
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	
	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}
	
	public void setBankDAO(BankDAO bankDAO) {
		this.bankDAO = bankDAO;
	}
	
	public BankDAO getBankDAO() {
		return bankDAO;
	}
	@Override
	public void transferFund(final Account fromAccount, final Account toAccount, final Double amount) {
		getTransactionTemplate().execute(new TransactionCallback<Void>() {

			@Override
			public Void doInTransaction(TransactionStatus paramTransactionStatus) {
				getBankDAO().withdraw(fromAccount, amount);
				getBankDAO().deposit(toAccount, amount);
				return null;
			}
		});
	}
	
	/*@Override
	public void transferFund(Account fromAccount, Account toAccount, Double amount) {
		getBankDAO().withdraw(fromAccount, amount);
		getBankDAO().deposit(toAccount, amount);
	}*/
}
