package encapsulation;

public class Employee {
	private String name;
	private String id;
	private double salary;
	private String dept;

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
	
	//Source > Generate getter
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public double getSalary() {
		return salary;
	}
	public String getDept() {
		return dept;
	}
	
	//함수도 encapsulation :외부 접근 x
	private double checkSalary(double salary) {
		double result = 0.0;
		if(salary < 0.0) {
			result = 0.0;
		} else {
			result = salary;
		}
		return result;
	}
	
	//setter
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(double salary) {
		this.salary = checkSalary(salary);
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
}





