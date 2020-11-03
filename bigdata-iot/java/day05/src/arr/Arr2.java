package arr;

import java.util.Random;

public class Arr2 {

	public static void main(String[] args) {
		int a[] = new int[5];
		Random r = new Random();
		for(int i=0 ; i<a.length ; i++) {
			a[i] = r.nextInt(9)+1;
		}
		
		
	}

}
