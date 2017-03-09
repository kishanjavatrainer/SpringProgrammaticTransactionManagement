package com.infotech.client;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infotech.model.Account;
import com.infotech.service.BankService;
import com.infotech.serviceImpl.BankServiceImpl;

public class ClientTest {

	public static void main(String[] args) {

		AbstractApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
		BankService bankService = context.getBean(BankServiceImpl.class, "bankService");
		
		Account fromAccount=new Account();
		fromAccount.setAccountNumber(112233);
		
		Account toAccount=new Account();
		toAccount.setAccountNumber(227788);
		
		bankService.transferFund(fromAccount, toAccount, 1000.00);
		
		context.close();
	}

}
