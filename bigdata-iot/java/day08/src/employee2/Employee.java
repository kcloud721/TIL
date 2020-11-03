package employee2;

public class Employee {
	protected String name;
	protected String id;
	protected double salary;
	protected String dept;
	//protected : 자식에 한해 접근 허용하는 인캡슐레이션
	// + 같은 디렉토리(패키지)에서도 접근가능
	
	public Employee() {
	}
	public Employee(String name, String id, double salary, String dept) {
		this.name = name;
		this.id = id;
		if(salary < 0) {
			salary = 0;
		}
		this.salary = salary;
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", salary=" + salary + ", dept=" + dept + "]";
	}
	public double annSalary() {
		double ann = 0.0;
		ann = this.salary * 12;
		return ann;
	}
	public double taxSalary() {
		double ann = 0.0;
		ann = this.salary * 12 * (1 - 0.022);
		return ann;
	}
}





