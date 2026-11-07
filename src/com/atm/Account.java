package com.atm;
import java.util.ArrayList;

public class Account {
	private int accountNumber;
	private int pin;
	private String name;
	private double balance;
	
	public Account(int accountNumber,int pin,String name,double balance) {
		this.accountNumber=accountNumber;
		this.pin=pin;
		this.name=name;
		this.balance=balance;
	}
	public int getAccountNumber(){
		return accountNumber;
	}
	public int getPin() {
		return pin;
	}
	public String getName() {
		return name;
	}
	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		if(amount>0) {
			balance+=amount;
		}
	}
	public boolean withdraw(double amount) {
		if(amount<=0) {
			System.out.println("Invalid Amount");
			return false;
		}
		else if(amount>balance) {
			System.out.println("Insufficient funds");
			return false;
		}
		else {
			balance-=amount;
			return true;
		}
	}
	private ArrayList<Transaction> transactions=new ArrayList<>();
	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);	
		}
	public void showTransactionHistory() {
		if(transactions.isEmpty()) {
			System.out.println("No Transactions available.");
			return;
		}
		for(Transaction transaction:transactions) {
			transaction.displayTransaction();
			System.out.println("---------------------------");
		}
	}
}
