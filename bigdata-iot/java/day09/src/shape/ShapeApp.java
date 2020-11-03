package shape;

public class ShapeApp {

	public static void main(String[] args) {
		Shape r = new Rectangle(5,3);
//		Shape c = new Circle(5);
		
		System.out.println(r.getArea());
		System.out.println(r.getCircum());
	}

}
