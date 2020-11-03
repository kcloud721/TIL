package str;

public class Str1 {

	public static void main(String[] args) {
		char c = 'A';	// 65
		String s1 = "A";
		String s2 = new String("A");
		
		String s3 = "A";
		String s4 = new String("A");
		
		// 주소 비교
		if (s1 == s4) {
			System.out.println("s1==s3");
		}
		
		//값 비교
		if (s1.equals(s1)) {
			System.out.println("equals");
		}
	}

}
