package account;

public class Account {
	String accNo;
	double balance;
	double rate;

	public Account(String accNo, double d, double e) {
		this.accNo = accNo;
		this.balance = d;
		this.rate = e;
	}

	public void newAcc(String accNo, double balance, double rate) {
		this.accNo = accNo;
		this.balance = balance;
		this.rate = rate;
	}
	
	//public Account(String accNo, double)
//	public void withdraw(double money) {
//		if(money<0 || balance<money)
//			return;
//		else {
//			this.balance -= money;
//			System.out.println("");
//		}
//	}
	public void deposit(double money) {
		this.balance += money;
		return;
	}
	
	public String withdraw(double money) {
		String msg = "";
		if(money<0 || balance<money) {
			
			return msg;
		}
		balance -= money;
		msg="Success";
		return msg;
		
	}
	
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", balance=" + balance + ", rate=" + rate + "]";
	}

}
