package op;

import java.util.Scanner;

public class Ws3 {

	public static void main(String[] args) {
		//한자리의 숫자를 입력받는다.
		Scanner sc = new Scanner(System.in);
		System.out.println("Insert number 1 : ");
		
		String s1 = sc.nextLine();
		int num1 = Integer.parseInt(s1);
		int data = 100;
		
		//입력 받은 값이 0보다 작으면 data에 10을 곱하고
		//그렇지 않으면 1을 곱한다.
		
		//SOLUTION1
//		int result = (num1 < 0) ? data*10 : data*1;
//		System.out.println(result);
		//SOLUTION2
		data = (num1<0) ? data*10 : data*1;
		sc.close();
		System.out.println(data);
		//SOLUTION3
//		data *= ((num1<0) ? 10:1);
//		System.out.println(data);
		
	}
}
