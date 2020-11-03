package Arr2;

import java.util.Random;

public class Arr2 {

	public static void main(String[] args) {
		int a2[][] = {
				{5,2,4,6,7},
				{3,6,8,9,2},
				{1,3,4,5,6},
				{6,5,4,5,3},
				{7,5,4,5,2}
		};
		
		//SUM, AVG;
		int sum=0, cnt=0;
		double avg=0.0;
		for(int i=0 ; i<a2.length ; i++) {
			for(int j=0 ; j<a2[i].length ; j++) {
				sum += a2[i][j];
				cnt++;
			}
		}
		avg=sum/cnt;
		System.out.println(sum);
		System.out.println(avg);
		
	}
}
