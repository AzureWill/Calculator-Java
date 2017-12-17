package calc.model;

public class AddOperator extends Operator{

	@Override
	public void execute(Operand left, Operand right) {
		left.add(right);
		
	}

}
