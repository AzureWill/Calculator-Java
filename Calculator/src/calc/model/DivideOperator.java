package calc.model;

public class DivideOperator extends Operator{

	@Override
	public void execute(Operand left, Operand right) {
		left.div(right);
		
	}
	
}
