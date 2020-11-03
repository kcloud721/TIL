package op;

import java.util.Scanner;

public class Ws1 {

	public static void main(String[] args) {
		// scanner 를 통해 두 수를 입력 받는다
		// 정수 형으로 변경하여 합을 구한다.
		
		//solution1 _ USING sc.nextInt()
		//Scanner sc = new Scanner(System.in);

		//System.out.println("STARING NOW");
		//System.out.println("Insert first number");
		//int num1 = sc.nextInt();
		//System.out.println("Insert second number");
		//int num2 = sc.nextInt();
		//int result = 0;
		//result = num1+num2;
		//String printing;
		//
		//printing = (result >= 10) ? "BIG" : "small";
		//sc.close();
		//System.out.println("ANSWER : "+printing);
		
		//solution2 _ USING sc.nextLine()
		Scanner sc = new Scanner(System.in);
		System.out.println("STARING NOW");
		
		System.out.println("Insert first number");
		String s1 = sc.nextLine();
		System.out.println("Insert second number");
		String s2 = sc.nextLine();
		int result = 0;
		result = Integer.parseInt(s1) + Integer.parseInt(s2);
		String printing="";
		printing = (result>=10) ? "BIG" : "small";
		sc.close();
		System.out.println("ANSWER : "+printing);
	}
}
