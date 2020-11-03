package str;

public class Str3 {

	public static void main(String[] args) {
		String email = "jmlee@tonesol.com";
		//id와  도메인 분리하여 스트링 만들고 출력
		int idx = email.indexOf("@");
		System.out.println("id: " + email.substring(0,idx));
		System.out.println("domain: " + email.substring(idx+1));
		
	}

}
