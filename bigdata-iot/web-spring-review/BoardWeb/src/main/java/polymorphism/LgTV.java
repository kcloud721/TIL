package polymorphism;

public class LgTV implements TV{
	public void powerOn() {
		System.out.println("LGTV power ON");
	}
	
	public void powerOff() {
		System.out.println("LGTV power OFF");
	}
	
	public void volumeUp() {
		System.out.println("LGTV vol UP");
	}
	
	public void volumeDown() {
		System.out.println("LGTV vol DOWN");
	}

}
