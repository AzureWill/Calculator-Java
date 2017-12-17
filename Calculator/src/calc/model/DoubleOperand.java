package calc.model;

public class DoubleOperand implements Operand{
	private String value = "0";
	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
		
	}

	@Override
	public void add(Operand right) {
		double x = Double.parseDouble(this.value);
		double y = Double.parseDouble(right.getValue());
		double result = x + y;
		this.value = String.valueOf(result);
	}

	@Override
	public void sub(Operand right) {
		double x = Double.parseDouble(this.value);
		double y = Double.parseDouble(right.getValue());
		double result = x - y;
		this.value = String.valueOf(result);
	}

	@Override
	public void mul(Operand right) {
		double x = Double.parseDouble(this.value);
		double y = Double.parseDouble(right.getValue());
		double result = x * y;
		this.value = String.valueOf(result);
	}

	@Override
	public void div(Operand right) {
		double x = Double.parseDouble(this.value);
		double y = Double.parseDouble(right.getValue());
		double result = x / y;
		this.value = String.valueOf(result);
	}
	
}
