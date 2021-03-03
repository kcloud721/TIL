import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int in = sc.nextInt();
		int result = 0;
		int n = 1;
		while(true){
			result += n;
			
			if(result >= in) {
				System.out.println(n);
				return;
			}
			n++;
		}
		
	}

}

