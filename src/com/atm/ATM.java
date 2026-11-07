package com.atm;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ATM {
	Bank bank;
	Account currentAccount;
	Scanner sc;
	public ATM(Bank bank) {
		this.bank=bank;
		sc=new Scanner(System.in);
	}
	public void login() {
		int attempts=0;
		boolean loggedIn=false;
		while(attempts<3 && !loggedIn) {
		System.out.print("Enter account number: ");
		int accountNumber=sc.nextInt();
		
		System.out.print("Enter PIN: ");
		int pin=sc.nextInt();
		
		Account acc=bank.authenticate(accountNumber, pin);
		if(acc!=null) {
			System.out.println("Welcome "+acc.getName());
			currentAccount=acc;
			loggedIn=true;
			showMenu();
		}
		else {
			attempts++;
			System.out.println("Login failed. Attempts remaining "+(3-attempts));
		}
	}
		if(!loggedIn) {
			System.out.println("Maximum attempts reached. Access denied");
		}
	}
	public void showMenu() {
		int choice;
		do {
		System.out.println("=======ATM MENU========");
		System.out.println("1.Transaction History");
		System.out.println("2.Withdraw");
		System.out.println("3.Deposit");
		System.out.println("4.Transfer");
		System.out.println("5.Quit");
		
		System.out.print("Enter your choice: ");
		choice=sc.nextInt();
		switch(choice) {
		case 1:
			currentAccount.showTransactionHistory();
			break;
		case 2:
			withdraw();
			break;
		case 3:
			deposit();
			break;
		case 4:
			transfer();
			break;
		case 5:
			System.out.println("Thank you for using ATM");
			break;
		default:
			System.out.println("Invalid choice");
		}
		}while(choice!=5);
	}
	public void deposit(){
		System.out.print("Enter amount to deposit: ");
		double amount=sc.nextDouble();
		if(amount<=0) {
			System.out.println("Please enter a valid amount.");
			return;
		}
		currentAccount.deposit(amount);
		System.out.println("Deposit successful!");
		Transaction transaction=new Transaction(
				"Deposit",
				 amount,
				 "Amount deposited successfully",
				 LocalDateTime.now()
				);
		currentAccount.addTransaction(transaction);
		System.out.println("Available balance: "+currentAccount.getBalance());
	}
	public void withdraw() {
		System.out.print("Enter amount: ");
		double amount=sc.nextDouble();
		if(currentAccount.withdraw(amount)) {
		System.out.println("Withdraw successful!");
		Transaction transaction=new Transaction(
				"Withdraw",
				amount,
				"Amount withdrawn successfully",
				LocalDateTime.now()
				);
		currentAccount.addTransaction(transaction);
		System.out.println("Current balance: "+currentAccount.getBalance());
	}
	}
	public void transfer() {
		System.out.print("Enter receiver account number: ");
		int receiverAccount=sc.nextInt();
		Account receiver=bank.findAccount(receiverAccount);
		if(receiver==null) {
			System.out.println("Account not found!");
			return;
		}
		else if(currentAccount.getAccountNumber()==receiver.getAccountNumber()) {
			System.out.println("We can't transfer money to our own account.");
			return;
		}
		System.out.print("Enter amount to transfer: ");
		double amount=sc.nextDouble();
		if(currentAccount.withdraw(amount)) {
			receiver.deposit(amount);
			System.out.println("Money transfer successful!");
			LocalDateTime transactionTime=LocalDateTime.now();
			Transaction senderTransaction=new Transaction(
					"Transfer",
					amount,
					"Money transferred to account "+receiverAccount,
					transactionTime
					);
			currentAccount.addTransaction(senderTransaction);
			
			Transaction receiverTransaction=new Transaction(
					"Received",
					amount,
					"Money received from account: "+currentAccount.getAccountNumber(),
					transactionTime
					);
			receiver.addTransaction(receiverTransaction);
			System.out.println("Your balance: "+currentAccount.getBalance());
		}
	}
}
