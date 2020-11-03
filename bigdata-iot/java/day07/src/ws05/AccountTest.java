package ws05;

public class AccountTest {

	public static void main(String[] args) {
		Account acc1 = new Account(500000, 7.3);
		acc1.setAccount("441-0290-1203");
		System.out.println("계좌정보: " + acc1.getAccount());
		System.out.println("잔액정보 : " + acc1.getBalance());
		
		acc1.deposit(20000);
		System.out.println("입금후잔액 " + acc1.getBalance());
//		acc1.withdraw(40000);
//		System.out.println("출금후잔액 " + acc1.getBalance());
		
		System.out.println("현재잔액기준이자 : " + acc1.calculateInterest());
		
		System.out.println(acc1);
	}
}
