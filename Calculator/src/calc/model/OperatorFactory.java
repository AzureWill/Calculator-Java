package calc.model;

public class OperatorFactory {
	private  static Operator[] ops;
	static{
		ops = new Operator[4];
		int i = 0;
		ops[i++] = new AddOperator();
		ops[i++] = new SubtractOperator();
		ops[i++] = new MulOperator();
		ops[i++] = new DivideOperator();
	}
	
	public static Operator create(OperatorType t) {
		return  ops[t.ordinal()];
	}
}
