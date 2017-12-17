package calc.model;

public class RightInputingStatus implements Status{
	private CalcServer server;
	@Override
	public void setServer(CalcServer server) {
		this.server = server;
		
	}

	@Override
	public void pressedNumber(String num) {
		num = server.getRightNumber() + num;
		server.setRightNumber(num);
	}

	@Override
	public void pressedOperator(String name) {
		server.execute();
		server.setOperator(name);
		server.setRightNumber(server.getLeftNumber());
		server.setStatus("RightInputed");
		
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
