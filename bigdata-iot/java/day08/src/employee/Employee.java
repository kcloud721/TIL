package employee;

public class Employee {
	String id;
	String name;
	double salary;
	String dept;
	
	public Employee() {
	}

	public Employee(String id, String name, double salary, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", dept=" + dept + "]";
	}
	
	public double annSalary() {
		double ann = 0.0;
		ann = this.salary*12;
		return ann;
	}
}
