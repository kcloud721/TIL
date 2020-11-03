package op;

import java.util.Scanner;

public class Ws2 {

	public static void main(String[] args) {
		// scanner 를 통해 두 수를 입력 받는다
		Scanner sc = new Scanner(System.in);
		System.out.println("STARING NOW");
		
		System.out.println("Insert first number");
		String s1 = sc.nextLine();
		System.out.println("Insert second number");
		String s2 = sc.nextLine();
		System.out.println("Insert third number");
		String s3 = sc.nextLine();
		System.out.println();
		//입력받은 두개 의 숫자 중 최대 값을 출력하시오
		
		//SOLUTION1
		//		int result1 = 0;
		//		int result2 = 0;
		//		int result3 = 0;
		//		int totalResult = 0;
		//		int totalResult2 = 0;
		//
		//
		//		result1 = (Integer.parseInt(s1) > Integer.parseInt(s2)) ? Integer.parseInt(s1) : Integer.parseInt(s2);
		//		result2 = (Integer.parseInt(s1) > Integer.parseInt(s3)) ? Integer.parseInt(s1) : Integer.parseInt(s3);
		//		result3 = (Integer.parseInt(s2) > Integer.parseInt(s3)) ? Integer.parseInt(s2) : Integer.parseInt(s3);
		//		totalResult = (result1 > result2) ? result1 : result2;
		//		totalResult2 = (totalResult > result3) ? totalResult : result3;
		//		
		//		sc.close();
		//		System.out.println(totalResult2);
		
		//SOLUTION2
		//		int num1 = Integer.parseInt(s1);
		//		int num2 = Integer.parseInt(s2);
		//		int num3 = Integer.parseInt(s3);
		//		int maxNum = 0;
		//		maxNum = ( ((num1>num2) ? num1 : num2) > num3) ? ((num1>num2) ? num1 : num2) : num3;
		//		sc.close();
		//		System.out.println(maxNum);
		
		
		int num1 = Integer.parseInt(s1);
		int num2 = Integer.parseInt(s2);
		int num3 = Integer.parseInt(s3);
		int minNum = 0;
		minNum = ( (num1 < num2 ? num1 : num2) < num3 ) ? ((num1 < num2 ? num1 : num2)) : num3;
		
//		minNum = (num1 < num2) ?
//					((num1 < num3) ? num1 : num3) :
//					((num2 < num3) ? num2 : num3) ;
		sc.close();
		System.out.println(minNum);
		
		
	}
}
