package employee2;

public class App {

	public static void main(String[] args) {
//		Employee e = new Employee("Lee", "11", 500, "M");
//		Manager m = new Manager("Kim", "22", 400, "M", 100);
//		System.out.println(e);
//		System.out.println(m);
//		
//		System.out.println(e.taxSalary());
//		System.out.println(m.taxSalary());
		
		
		long totalPrize = 5000000000L; // 총 상금
        int fourthPrize = 5000; // 4등 상금
        System.out.println(2*((totalPrize - fourthPrize*2)*0.25));
	}
}
