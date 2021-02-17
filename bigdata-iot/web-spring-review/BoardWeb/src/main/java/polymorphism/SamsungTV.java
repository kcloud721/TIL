package polymorphism;

public class SamsungTV implements TV{
	private SonySpeaker speaker;
	
	public SamsungTV() {
		System.out.println("===> SS TV 객체 생성");
	}
	
	public SamsungTV(SonySpeaker speaker) {
		System.out.println("====> SSTV ((2)) 객체 생성");
		this.speaker = speaker;
	}
	
	public void initMethod() {
		System.out.println("SSTV INIT 메서드");
	}
	
	public void destroyMethod() {
		System.out.println("SSTV Destroy 메서드");
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
//		speaker = new SonySpeaker();
		speaker.volumeUp();
//		System.out.println("SSTV vol UP");
		
	}

	@Override
	public void volumeDown() {
//		speaker = new SonySpeaker();
		speaker.volumeDown();
//		System.out.println("SSTV vol DOWN");
		
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
