package account;

//exception을 슈퍼클래스로
//나만의 exception
public class NotEnoughException extends Exception {
	public NotEnoughException() {
		super();
	}
	public NotEnoughException(String msg) {
		super(msg);
	}
}
