package employee2;

public class App3 {

	public static void main(String[] args) {
		Employee es[] = new Employee[3];
		es[0] = new Employee("Seo", "00", 500, "M");
		es[1] = new Manager("Lee", "11", 500, "M", 100);
		es[2] = new Sales("Kim", "11", 500, "M", "Seou", 100);
		
//		Employee e = new Manager("Lee", "11", 500, "M", 100);
//		Employee e1 = new Sales("Kim", "11", 500, "M", "Seou", 100);
//		
		for(int i=0 ; i<es.length ; i++) {
			System.out.println(es[i].annSalary());
		}
		
	}

}
