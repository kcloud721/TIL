package arr;

import java.util.Arrays;
import java.util.Random;

public class Arr5 {

	public static void main(String[] args) {
	 	int a[] = new int[10];
		int a2[] = new int[10];
		
		for(int i=0 ; i<a.length ; i++) {
			Random r = new Random();
			a[i] = r.nextInt(10);
			System.out.print(a[i] + " ");
		}
		
		System.out.println("");
		
		//배열 데이터의 합과 평균 > 중복 X
		int sum=0, cnt=1, ov=0;
		for(int i=0 ; i<a.length ; i++) {
			for(int j=0; j<a2.length ; j++) {
				if(a[i] == a2[j])
					ov=1;
			}
			if(ov==1) {
				ov=0;
			} else {
				a2[cnt]=a[i];
				cnt++;
				ov=0;
			}
		}	
		
		System.out.println(Arrays.toString(a2));
		
		for(int i=0 ; i<cnt ; i++) {
			sum+=a2[i];
		}
		
		System.out.println("cnt: " + cnt);
		System.out.println("sum: " +sum);
		System.out.println("avg: " + (float)sum/cnt);
		
	}

}
