package calc.model;

public interface Status {
	void setServer(CalcServer server);
	void pressedNumber(String num);
	void pressedOperator(String name);
	void pressedEqual();
	void pressedClear();
}
