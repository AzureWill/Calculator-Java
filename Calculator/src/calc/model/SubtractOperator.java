package calc.model;

public class SubtractOperator extends Operator{

	@Override
	public void execute(Operand left, Operand right) {
		left.sub(right);
		
	}

}
