package arr;

import java.util.Arrays;

public class Arr4 {

	public static void main(String[] args) {
		int a[] = {80, 30, 20, 40};
		System.out.println(Arrays.toString(a));
		int max=0, min=a[0];
		
		//최대-최소
		for(int i=0 ; i<a.length ; i++) {
			if(a[i] > max)
				max = a[i];
			else if(a[i] < min)
				min = a[i];
		}
		System.out.println("MAX:"+max);
		System.out.println("MIN:"+min);
		
	}

}
