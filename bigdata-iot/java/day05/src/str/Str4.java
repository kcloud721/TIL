package str;

public class Str4 {

	public static void main(String[] args) {
		String s1 = new String("ABC");
		StringBuffer sb1 = new StringBuffer("ABC");
		sb1.append("DEF");
		System.out.println(sb1.toString());
		
		//StringBuffer : 문자 자유롭게 뗏다 붙였다
	}

}
