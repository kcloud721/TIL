package tv;

public class App {

	public static void main(String[] args) {
		Factory factory = new Factory();
		Tv tv1 = new Tv("Television", 60);
		Tv tv2 = new DvdTv("DVD Television", 50);
		Tv tv3 = new LcdTv("LCD Television", 70);
		
		factory.repairTv(tv1);
		factory.repairTv(tv2);
		factory.repairTv(tv3);
		
		Object o1 = new Tv();
		Object o2 = new DvdTv();
		Object o3 = new String("aaa");
		System.out.println(o1);
		System.out.println(o2);
		System.out.println(o3);

	}

}
