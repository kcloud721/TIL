package arr;

import java.util.Arrays;

public class Arr3 {

	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		//배열의 홀수번째 정수 합
		int sum = 0;
		for(int i=0 ; i<arr.length ; i++) {
			if(i%2 == 1)
				sum += arr[i];
		}
		System.out.println(sum);
		
	}

}
