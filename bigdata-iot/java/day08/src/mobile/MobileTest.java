package mobile;

public class MobileTest {

	public static void main(String[] args) {
		Ltab l = new Ltab("Ltab", 500, "AP-01");
		Otab o = new Otab("Otab", 1000, "AND-20");
		
		System.out.println(l);
		System.out.println(o);
		
		//각 개체 10분 충전 후 잔량 출력
		int l_batt = l.charge(10);
		int o_batt = o.charge(10);
		System.out.println("\n 10분 충전 ==============");
		System.out.println(l);
		System.out.println(o);
		
		//각 개체 5분 통화 후 잔량 출력
		l_batt = l.operate(5);
		o_batt = o.operate(5);
		System.out.println("\n 5분 통화 ==============");
		System.out.println(l);
		System.out.println(o);
	}

}
