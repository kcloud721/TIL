package tv;

public class Tv {
	//attribute
	String color;
	boolean power;
	int channel;
	
	//Constructor 생성자 -- 객체 만들어질 때 속성값 초기화
	public Tv() {
		this.color = "black";
		this.power = false;
		this.channel = 10;
	}
	
	//생성자의 생성자 : 생성할 때 변수 입력으로 초기화 가능
	public Tv(String color, boolean power, int channel) {
		this.color = color;
		this.power = power;
		this.channel = channel;
	}
	
	//behavior, function, method
	public void powerOn() {
		power = true;
	}
	public void powerOff() {
		power = false;
	}
	public void channelUp() {
		channel += 1;
	}
	public void channelDown() {
		channel -= 1;
	}
	@Override
	public String toString() {
		return "Tv [color=" + color + ", power=" + power + ", channel=" + channel + "]";
	}
	
	
}
