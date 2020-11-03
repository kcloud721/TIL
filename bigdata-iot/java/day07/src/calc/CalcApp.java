package calc;

import java.util.Scanner;

public class CalcApp {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Input num1");
		double n1 = Integer.parseInt(s.nextLine());
		System.out.println("Input num2");
		double n2 = Integer.parseInt(s.nextLine());
		
//		Calc c = new Calc();
//		double sum = c.add(n1,n2);
//		System.out.println(n1 + " + " + n2 + " = " +sum);
		
		double sum2 = Calc.add(n1, n2);
		System.out.println(n1 + " + " + n2 + " = " +sum2);
				
	}

}
