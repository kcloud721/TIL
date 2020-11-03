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
	
	public void withdraw(double money) 
	throws InvalidMoneyException, NotEnoughException {
// 	throws Exception {
		if(money <= 0) {
			//throw new InvalidMoneyException("Invalid Money"); 
			//여기서 Exception걸리면 이 이후의 라인 실행 X
			//때문에 return 필요 X
			//return;
		} if(balance < money) {
			throw new NotEnoughException("Not Enough Money"); 
			//return;
		}
		balance -= money;		
	}
	
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", balance=" + balance + ", rate=" + rate + "]";
	}

}
