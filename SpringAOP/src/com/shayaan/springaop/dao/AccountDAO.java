package com.shayaan.springaop.dao;

import java.util.ArrayList;
import java.util.List;

import com.shayaan.springaop.Account;
import org.springframework.stereotype.Component;


@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public List<Account> findAccounts(boolean tripWire) {
		
		if (tripWire) {
			throw new RuntimeException("ERRORRRRRR!!!");
		}	
		
		List<Account> myAccounts = new ArrayList<>();
		
		Account temp1 = new Account("Muhammad", "Gold");
		Account temp2 = new Account("Maria", "Platinum");
		Account temp3 = new Account("Ali", "Gold");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		
		return myAccounts;		
	}

	
	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
	
	public boolean doWork() {
		
		System.out.println(getClass() + ": doWork()");
		return false;
	}

	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
	
	
}





