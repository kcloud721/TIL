package gene;

import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		Factory<Macaron> f = new Factory<>();
		Macaron m1 = new Macaron("M1", 1000);
		Macaron m2 = new Macaron("M2", 2000);
		Macaron m3 = new Macaron("M3", 3000);
		f.addItem(m1);
		f.addItem(m2);
		f.addItem(m3);
		
//		Factory<Macaron> f2 = new Factory<>();
//		Candy c1 = new Candy("CC", 20, 20);
//		f2.addItem(c1);
		
		ArrayList<Macaron> list = f.getList();
		
		for(Macaron m : list) {
			System.out.println(m);
		}
	}

}
