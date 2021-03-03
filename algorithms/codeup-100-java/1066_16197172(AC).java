import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] aa = new int[3];
		for(int i=0; i<aa.length; i++) {
			aa[i] = sc.nextInt();
			if(aa[i] % 2 == 0)
				System.out.println("even");
			else 
				System.out.println("odd");
		}
		
	}

}

