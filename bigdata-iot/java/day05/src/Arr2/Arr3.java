package Arr2;

import java.util.Random;

public class Arr3 {

	public static void main(String[] args) {
		int a2[][] = {
				{5,2,4,6,7},
				{3,6,8,9,2},
				{1,3,4,5,6},
				{6,5,4,5,3},
				{7,5,4,5,2}
		};
		
		//대각선의 합
		int sum=0;
		ou:
		for(int i=0 ; i<a2.length ; i++) {
			for(int j=0 ; j<a2[i].length ; j++) {
				if(i == j)
					sum+=a2[i][j];
				if(i==2 && j==2)
					break ou;
			}
		};
		System.out.println(sum);
	}
}
