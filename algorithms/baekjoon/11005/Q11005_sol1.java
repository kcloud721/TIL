package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Q11005_sol1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
//		int N = 8484848;
//		int B = 36;
		int N = sc.nextInt();
		int B = sc.nextInt();
		
		while(N > 0) {
			if(N%B < 10) {
				list.add(Integer.toString(N%B));
				N/=B;
			} else {
				switch(N%B) {
				case 10: list.add("A"); break;
				case 11: list.add("B"); break;
				case 12: list.add("C"); break;
				case 13: list.add("D"); break;
				case 14: list.add("E"); break;
				case 15: list.add("F"); break;
				case 16: list.add("G"); break;
				case 17: list.add("H"); break;
				case 18: list.add("I"); break;
				case 19: list.add("J"); break;
				case 20: list.add("K"); break;
				case 21: list.add("L"); break;
				case 22: list.add("M"); break;
				case 23: list.add("N"); break;
				case 24: list.add("O"); break;
				case 25: list.add("P"); break;
				case 26: list.add("Q"); break;
				case 27: list.add("R"); break;
				case 28: list.add("S"); break;
				case 29: list.add("T"); break;
				case 30: list.add("U"); break;
				case 31: list.add("V"); break;
				case 32: list.add("W"); break;
				case 33: list.add("X"); break;
				case 34: list.add("Y"); break;
				case 35: list.add("Z"); break;
				}
				N/=B;
			}
		}
		for(int i=list.size()-1; i>=0; i--) {
			System.out.print(list.get(i));
		}
	}

}
