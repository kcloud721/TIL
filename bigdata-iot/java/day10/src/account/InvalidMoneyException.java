package account;

//exception을 슈퍼클래스로
//나만의 exception
public class InvalidMoneyException extends Exception {
	public InvalidMoneyException() {
		super();
	}
	public InvalidMoneyException(String msg) {
		super(msg);
	}
}
