package calc.model;

public class LeftInputingStatus implements Status{
	private CalcServer server;
	
	
	@Override
	public void setServer(CalcServer server) {
		this.server = server;
		
	}

	@Override
	public void pressedNumber(String num) {
		if(server.getLeftNumber().contains(".")&& num.equals(".")) return;
		num = server.getLeftNumber() + num;
		server.setLeftNumber(num);
		
	}

	@Override
	public void pressedOperator(String name) {
		server.setOperator(name);
		server.setRightNumber(server.getLeftNumber());
		server.setStatus("RightInputed");
	}

	@Override
	public void pressedEqual() {
		server.execute();
		server.setRightNumber(server.getLeftNumber());
		server.setStatus("LeftInputed");
	}

	@Override
	public void pressedClear() {
		server.clear();
		
	}
	
}
