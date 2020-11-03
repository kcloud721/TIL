package encapsulation;

public class App2 {

	public static void main(String[] args) {
		Employee e = new Employee("Lee", "11", 500, "M");
		//e.salary = -100;
		//getter를 통해 private(encapsulation) 해놓은거 접근가능
		System.out.println(e.getName() + " " + e.getSalary());
		//setter로 encapsulation 변경가능
		//name에 대해 열어두어서 가능, id-salary는 setter 선언 안해서 못바꿈
		e.setName("Kim");
	}

}
