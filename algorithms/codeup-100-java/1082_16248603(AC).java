import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		int a10 = Integer.valueOf(a, 16);
		
		for(int i=1; i<16; i++) {
			String hex = Integer.toHexString(i);
			String result16 = Integer.toHexString(a10*i);
			System.out.printf("%s*%S=%S\n", a, hex, result16);
		}
		
	}

}

