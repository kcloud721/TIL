package gene;

import java.util.HashMap;
import java.util.Set;

public class App2 {

	public static void main(String[] args) {
		Cart<Integer, Product> cart = new Cart<>();
		Macaron m = new Macaron("Macaron", 1000);
		Candy c = new Candy("Candy", 2000, 10);
		
		cart.addCart(1, m);
		cart.addCart(2, c);
		
		//카트 모든 정보 갖고와서
		HashMap<Integer, Product> map = cart.getCart();
		
		//출력
		Set<Integer> keys = map.keySet();
		for(int i:keys) {
			System.out.println(map.get(i));
		}
		//Total price
		int total=0;
		for(int i:keys) {
			total += map.get(i).getPrice(); //or .price
		}
		System.out.println("total: "+total);
	}

}
