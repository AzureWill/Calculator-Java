package calc.model;

public class CalcServer {
	private Operand left;
	private Operand right;
	private Operator op;
	private Status status;
	private ResultListener listener;
	
	
	public void addResultListener(ResultListener listener){
		this.listener = listener;
	}
	
	public CalcServer(){
		left = new DoubleOperand();
		right = new DoubleOperand();
		setStatus("LeftInputed");
	}
	
	public void clear(){
		left.setValue("0");
		right.setValue("0");
		op = null;
		setStatus("LeftInputed");
		if(listener != null) listener.show("0");
	}
	
	public void execute() {
		if (op == null) return;
		
		op.execute(left, right);
		String text = left.getValue().replace("\\.0$", "");  //处理.0的正则表达式
		if(listener != null) listener.show(text);
	}
	
	public void pressedNumber(String num){
		status.pressedNumber(num);
	}
	
	public void  pressedOperator(String name) {
		status.pressedOperator(name);
	}
	
	public void pressedEqual() {
		status.pressedEqual();
	}
	
	public void pressedClear(){
		status.pressedClear();
	}
	
	public void setStatus(String name){
		StatusType t = StatusType.valueOf(name);
		status = StatusFactory.create(t);
		status.setServer(this);
	}
	
	public void setOperator(String name){
		OperatorType t = OperatorType.valueOf(name);
		op = OperatorFactory.create(t);
	}
	
	public String getLeftNumber() {
		return left.getValue();
	}
	
	public void setLeftNumber(String num) {
		left.setValue(num);
		if(listener != null) listener.show(num);
	}
	
	public String getRightNumber() {
		return right.getValue();
		
	}
	
	public void setRightNumber(String num) {
		right.setValue(num);
		if(listener != null) listener.show(num);
	}
}
