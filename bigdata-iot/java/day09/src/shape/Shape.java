package shape;

public abstract class Shape {
	protected double x;
	protected double y;
	
	public Shape() {
	}
	
	public Shape(double x) {
		this.x = x;
	}
	
	public Shape(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public abstract double getArea();
	public abstract double getCircum();
	
//	abstract double getArea(double x, double y) {
//		
//	}
//	
//	abstract double getCircum() {
//		
//	}
	
}
