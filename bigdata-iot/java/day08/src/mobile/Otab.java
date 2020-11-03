package mobile;

public class Otab extends Mobile{
	public Otab() {
	}
	public Otab(String mobileName, int batterySize, String osType) {
		super(mobileName, batterySize, osType);
	}
	
	//1분 사용 시 배터리 12감소 > 잔여배터리 리턴
	//time단위 : 분
	public int operate(int time) {
		this.batterySize -= time*12;
		return this.batterySize;
	}

	//1분 충전시 배터리 8증가 > 잔여배터리 리턴
	//time단위 : 분
	public int charge(int time) {
		this.batterySize += time*8;
		return this.batterySize;
	}
	
	@Override
	public String toString() {
		return "Otab [mobileName=" + mobileName + ", batterySize=" + batterySize + ", osType=" + osType + "]";
	}
}
