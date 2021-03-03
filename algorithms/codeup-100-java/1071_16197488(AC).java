import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int a = sc.nextInt();
			if(a != 0)
				System.out.println(a);
			else
				return;
		}
		
		
	}

}

