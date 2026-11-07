package com.atm;
import java.util.ArrayList;

public class Bank {	
   private ArrayList<Account> account= new ArrayList<>();
   public Bank() {
	   account.add(new Account(1001,1234,"Naidu",6000));
	   account.add(new Account(1002,5678,"Ravi",1500));
	   account.add(new Account(1003,9012,"Vamsi",4500));
   }
   public Account findAccount(int accountNumber) {
	   for(Account acc:account) {
		   if(acc.getAccountNumber()==accountNumber) {
			   return acc;
		   }
	   }
	   return null;
   }
   public Account authenticate(int accountNumber,int pin) {
	   Account acc=findAccount(accountNumber);
	   if(acc==null) {
		   return null;
	   }
	   if(acc.getPin()==pin) {
		   return acc;
	   }
	   System.out.println("Incorrect PIN");
	   return null;
   }
}
