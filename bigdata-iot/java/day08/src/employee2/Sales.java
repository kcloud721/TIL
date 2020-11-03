package employee2;

public class Sales extends Employee {
	String location;
	double extraPay;
	public Sales() {
	}
	public Sales(String name, String id, double salary, String dept, String location, double extraPay) {
		super(name, id, salary, dept);
		this.location = location;
		this.extraPay = extraPay;
	}
	
	@Override
	public double annSalary() {
		double ann = 0.0;
		ann = super.annSalary() + (extraPay * 12);
		return ann;
	}
	@Override
	public String toString() {
		return "Sales [name=" + name + ", id=" + id + ", salary=" + salary + ", dept=" + dept + ", location=" + location
				+ ", extraPay=" + extraPay + "]";
	}
	
}



