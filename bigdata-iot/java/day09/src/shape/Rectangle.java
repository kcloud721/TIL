package shape;

public class Rectangle extends Shape {
	protected double x;
	protected double y;
	
	public Rectangle() {
	}
	
	public Rectangle(double x, double y) {
		super(x, y);
		this.x = x;
		this.y = y;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getArea() {
		double area = x*y;
		return area;
	}

	@Override
	public double getCircum() {
		double circum = 2*x + 2*y;
		return circum;
	}
}
