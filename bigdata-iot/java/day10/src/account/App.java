package account;

public class App {
	public static void main(String[] args) {
		Account acc1 = new Account("111", 10000.0, 3.8);
		System.out.println(acc1);
		acc1.deposit(15000);
		System.out.println(acc1);
		try {
			acc1.withdraw(50000);
//		} catch (Exception e1) {
//			System.out.println(e1.getMessage());
		} catch (InvalidMoneyException e) {
			System.out.println(e.getMessage());
		} catch (NotEnoughException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(acc1);
		 
	}
}
