package polymorphism;

public class SamsungTV implements TV{
	public SamsungTV() {
		System.out.println("===> SS TV 객체 생성");
	}

	@Override
	public void powerOn() {
		System.out.println("SSTV power ON");
		
	}

	@Override
	public void powerOff() {
		System.out.println("SSTV power OFF");
		
	}

	@Override
	public void volumeUp() {
		System.out.println("SSTV vol UP");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("SSTV vol DOWN");
		
	}
//	public void powerOn() {
//		System.out.println("SSTV power ON");
//	}
//	
//	public void powerOff() {
//		System.out.println("SSTV power OFF");
//	}
//	
//	public void volumeUp() {
//		System.out.println("SSTV vol UP");
//	}
//	
//	public void volumeDown() {
//		System.out.println("SSTV vol DOWN");
//	}

}
