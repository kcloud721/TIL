package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q11006_sol2 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//		int N = 8484848;
//		int B = 36;
		int N = sc.nextInt();
		int B = sc.nextInt();
		
        List<Character> list = new ArrayList<>();
        while(N > 0) {
            if(N%B < 10) {
                list.add((char)(N%B + '0'));
            } else {
                list.add((char)(N%B - 10 + 'A'));
            }
            N/=B;
        }
        for(int i=list.size()-1; i>=0; i--)
            System.out.print(list.get(i));
    }
}
