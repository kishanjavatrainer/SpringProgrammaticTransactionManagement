package com.infotech.daoImpl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.infotech.dao.BankDAO;
import com.infotech.model.Account;


public class BankDAOImpl extends JdbcDaoSupport implements BankDAO {

	
	@Override
	public void withdraw(Account fromAccount, Double withdrawAmt) {
		String sql="UPDATE icici_bank set account_balance=account_balance-"+withdrawAmt+" WHERE account_no=?;";
		 int update = getJdbcTemplate().update(sql,fromAccount.getAccountNumber());
		 if(update>0)
			 System.out.println("Amount Rs:"+withdrawAmt+" is deducted from account:"+fromAccount.getAccountNumber());
	}

	@Override
	public void deposit(Account toAccount, Double depositAmt) {
		String sql="UPDATE icici_bank set account_balance=account_balance+"+depositAmt+" WHERE account_no=?;";
		int update = getJdbcTemplate().update(sql,toAccount.getAccountNumber());
		 if(update>0)
			 System.out.println("Amount Rs: "+depositAmt+" is deposited in Account:"+toAccount.getAccountNumber());
	}

}
