package ws06;

import java.util.Arrays;

public class Account {
	String account;
	int balance;
	double interestRate;
	
	public Account() {}
	
	public Account(int balance, double interestRate) {
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	public Account(String account, int balance, double interestRate) {
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	public void accountInfo() {
		System.out.printf("°èÁÂ¹øÈ£: %s  ÀÜ¾× : %d \n", this.account, this.balance);
	}

	@Override
	public String toString() {
		return "Account [account=" + account + ", balance=" + balance + ", interestRate=" + interestRate + "]";
	}
	 
}
