package tv;

public class App {

	public static void main(String[] args) {
//		Tv tv = new Tv();
//		System.out.println(tv.toString());
//		tv.powerOn();
//		tv.channelDown();
//		System.out.println(tv.toString());
		
		int a = 10;
		
		Tv tv2 = new Tv("red", false, 100);
		System.out.println(tv2.toString());
		Tv tv3 = new Tv("black", false, 50);
		System.out.println(tv3.toString());
		
	}

}
