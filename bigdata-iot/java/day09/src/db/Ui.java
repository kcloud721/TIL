package db;

import java.util.Arrays;

public class Ui {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DbImpl dbi = new DbImpl("192.168.111.1", 1000);
		User u = new User("id01", "pwd01", "Lee");
		dbi.insert(u);
		dbi.delete("id01");
		User uu = new User("id01", "pwd02", "Kim");
		dbi.update(uu);
		System.out.println("-------------------");
		User dbu = dbi.select("id01");
		System.out.println(dbu);
		System.out.println("-------------------");
		User us[] = dbi.select();
		System.out.println(Arrays.toString(us));
		
		//us 묶음에서 하나씩 꺼내서 uus에 넣음 > 끝까지
		for(User uus:us) {
			System.out.println(uus);
		}
	}

}
