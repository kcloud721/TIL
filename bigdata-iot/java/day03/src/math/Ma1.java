package math;

import java.util.Random;

public class Ma1 {
	public static void main(String[] args) {
		// 난수발생
		// 0.0 <= x < 1.0
		double d = Math.random();
		System.out.println(d);

		// 1~10
		int num1 = (int) (Math.random() * 10) + 1;
		System.out.println(num1);

		// Random 1~5
		Random r = new Random();
		int num2 = r.nextInt(5) + 1;
		System.out.println(num2);

		// 반올림
		double num3 = 12.54356;
		double num4 = (double) Math.round(num3 * 1000) / 1000;
		System.out.println(num4);

		// 삼각형의 빗변의 길이를 구하시오.
		// 가로 10 세로 5
		int x = 10;
		int y = 5;
		double z = 0;
		z = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		// z = Math.hypot(x, y);
		System.out.println(z);
	}
}
