package mobile;

public class Mobile {
	String mobileName;	
	int batterySize;
	String osType;
	
	public Mobile() {
	}

	public Mobile(String mobileName, int batterySize, String osType) {
		super();
		this.mobileName = mobileName;
		this.batterySize = batterySize;
		this.osType = osType;
	}
	
	//1분 사용 시 배터리 10감소 > 잔여배터리 리턴
	//time단위 : 분
	public int operate(int time) {
		this.batterySize -= time*10;
		return this.batterySize;
	}

	//1분 충전시 배터리 10증가 > 잔여배터리 리턴
	//time단위 : 분
	public int charge(int time) {
		this.batterySize += time*10;
		return this.batterySize;
	}

	@Override
	public String toString() {
		return "Mobile [mobileName=" + mobileName + ", batterySize=" + batterySize + ", osType=" + osType + "]";
	}
}
