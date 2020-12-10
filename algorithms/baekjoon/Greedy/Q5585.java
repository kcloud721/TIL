package baekjoon;

import java.util.Scanner;

// https://www.acmicpc.net/submit/5585
public class Q5585 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mymoney = 1000;
		int price = sc.nextInt();
		int changes = 0;
		int cnt = 0;
		int[] coin = {500, 100, 50, 10, 5, 1};
		
		
		//나머지가 0이면 몫을 더하고
		// 아니면 나머지값을 남기고 +1 
		changes = 1000 - price;
		for(int i=0; i<6; i++) {
			System.out.println("changes: "+changes);
			if(changes%coin[i] == 0) {
				cnt += changes/coin[i];
				System.out.println("if"+cnt);
				break;
			} else {
				cnt += changes/coin[i];
				changes %= coin[i];
				System.out.println("else"+cnt);

			}
		}
		System.out.println(cnt);
		
	}

}
