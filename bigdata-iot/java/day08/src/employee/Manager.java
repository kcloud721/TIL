package employee;

public class Manager {
	String id;
	String name;
	double salary;
	String dept;
	double incentive;
	
	public Manager() {
	}

	public Manager(String id, String name, double salary, String dept, double incentive) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dept = dept;
		this.incentive = incentive;
	}


	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", salary=" + salary + ", dept=" + dept + ", incentive="
				+ incentive + "]";
	}
	
	public double annSalary() {
		double ann = 0.0;
		ann = this.salary*12;
		return ann;
	}
}
