package variable;

public class Var5 {

	public static void main(String[] args) {
		int a = 10;
		String s1 = "ABC";
		String s2 = s1 + 10;
		
		System.out.printf("%s \n", s1);
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		
		int oct = 010; //앞에 0붙으면 8진수
		int hex = 0x10;
		System.out.printf("Result: %d, %o, %x \n", oct, oct, oct);
		System.out.printf("Result: %d, %x \n", hex, hex, hex);	
	}

}
