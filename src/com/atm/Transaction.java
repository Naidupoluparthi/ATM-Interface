package com.atm;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
	private String transactionType;
	private double amount;
	private String description;
	private LocalDateTime dateTime;
	
	public Transaction(String transactionType, double amount,String description,LocalDateTime dateTime) {
		this.transactionType=transactionType;
		this.amount=amount;
		this.description=description;
		this.dateTime=dateTime;
	}
	
	public String getTransactionType() {
		return transactionType;
	}
	public double getAmount() {
		return amount;
	}
	public String getDescription() {
		return description;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void displayTransaction() {
		System.out.println("Transaction Type: "+transactionType);
		System.out.println("Amount: "+amount);
		System.out.println("Description: "+description);
		System.out.println("Date & Time: "+
							dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a")
						   ));
	}

}
