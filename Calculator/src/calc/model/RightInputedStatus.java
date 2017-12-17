package calc.model;

public class RightInputedStatus implements Status{
	private CalcServer server;
	
	@Override
	public void setServer(CalcServer server) {
		this.server = server;
		
	}

	@Override
	public void pressedNumber(String num) {
		if(num.equals(".")) num = "0.";
		server.setRightNumber(num);
		server.setStatus("RightInputing");
		
	}

	@Override
	public void pressedOperator(String name) {
		server.setOperator(name);
		
	}

	@Override
	public void pressedEqual() {
		server.execute();
		server.setStatus("LeftInputed");
		
	}

	@Override
	public void pressedClear() {
		server.clear();
		
	}

}
