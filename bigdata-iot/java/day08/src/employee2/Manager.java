package employee2;

public class Manager extends Employee{
	
	double incentive;

	public Manager() {
	}
	public Manager(String name, String id, double salary, String dept, double incentive) {
		super(name,id,salary,dept);
		this.incentive = incentive;
	}
	@Override
	public String toString() {
		return "Manager: " + super.toString() + incentive;
	}
	
	// overriding (¿Á¡§¿«)
	public double annSalary() {
		double ann = 0.0;
		ann = super.annSalary() + this.incentive;
		return ann;
	}
}
