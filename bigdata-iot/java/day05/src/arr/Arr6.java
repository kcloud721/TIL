package arr;

import java.util.Arrays;
import java.util.Random;

public class Arr6 {

	public static void main(String[] args) {
	 	int a[] = new int[10];
		Random r = new Random();
		for(int i=0 ; i<a.length ; i++) {
			a[i] = r.nextInt(10);
			if(i != 0) {
				for(int j=0 ; j<i ; j++) {
					if(a[i] == a[j]) {
						i--; // ???
						break;
					} else {
						
					}
				}
				
			}
		}
		System.out.println(Arrays.toString(a));
	}

}
