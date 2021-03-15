import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String zero = "0";
		
		String date[] = a.split("[.]");
		int l = date[0].length();
		if(date[0].length() != 4) {
			for(int i=0; i<4-l; i++){
				date[0] = zero.concat(date[0]);
			}
		}
		
		for(int i=1; i<=2; i++) {
			if(date[i].substring(0,1).equals("0"))
				continue;
			else if(date[i].length() != 2)
				date[i] = zero.concat(date[i]);
		}
		System.out.println(date[0]+"."+date[1]+"."+date[2]);
		
	}
}
