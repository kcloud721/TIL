package ws05;

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
	
	//계좌정보 셋팅
	public void setAccount(String account) {
		this.account = account;
	}
	//계좌정보리턴
	public String getAccount() {
		return this.account;
	}
	//잔액정보리턴
	 public int getBalance() {
		 return this.balance;
	 }
	 //현재잔액기준 이자계산
	 public double calculateInterest() {
		 return this.balance * this.interestRate * 0.01;
	 }
	 //입금
	 public void deposit(int money) {
		 if(money >= 0) {
			 this.balance += money;
		 } else {
			 System.out.println("Invalid Value ..");
			 return;
		 }
	 }
	 //출금
	 public void withdraw(int money) {
		 if(money >= 0) {
			 this.balance -= money;
		 } else {
			 System.out.println("Invalid Value ..");
			 return;
		 }
	 }
	@Override
	public String toString() {
		return "Account [account=" + account + ", balance=" + balance + ", interestRate=" + interestRate + "]";
	}
	 
}
