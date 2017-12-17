package calc.model;

public interface Operand {
	String getValue();
	void setValue(String value);
	void add(Operand right);
	void sub(Operand right);
	void mul(Operand right);
	void div(Operand right);
}
