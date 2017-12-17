package calc.model;

public class LeftInputedStatus implements Status{
	private CalcServer server;
	
	@Override
	public void setServer(CalcServer server) {
		this.server = server;
	}

	@Override
	public void pressedNumber(String num) {
		if(num.equals(".")) num = "0.";
		server.setLeftNumber(num);
		server.setStatus("LeftInputing");
	}

	@Override
	public void pressedOperator(String name) {
		server.setOperator(name);
		server.setStatus("RightInputed");
	}

	@Override
	public void pressedEqual() {
		server.execute();
	}

	@Override
	public void pressedClear() {
		server.clear();
	}

}
