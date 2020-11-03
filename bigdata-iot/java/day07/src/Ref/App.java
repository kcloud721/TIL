package Ref;

public class App {

	public static void main(String[] args) {
		Ref ref = new Ref("G1");
		Tv tv = new Tv("T1");
		ref.setTv(tv);
		
		System.out.println(ref);
		
		ref.on();
		
	}

}
