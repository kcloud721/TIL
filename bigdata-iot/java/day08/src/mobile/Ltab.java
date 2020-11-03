package mobile;

public class Ltab extends Mobile{
	public Ltab() {
	}
	public Ltab(String mobileName, int batterySize, String osType) {
		super(mobileName, batterySize, osType);
	}
	
	@Override
	public String toString() {
		return "Ltab [mobileName=" + mobileName + ", batterySize=" + batterySize + ", osType=" + osType + "]";
	}
}
