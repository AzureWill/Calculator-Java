package calc.model;

public class MulOperator extends Operator{

	@Override
	public void execute(Operand left, Operand right) {
		left.mul(right);
		
	}

}
