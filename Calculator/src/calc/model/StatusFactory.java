package calc.model;

public class StatusFactory {
	private static Status[] cs;
	
	
	static{
		cs = new Status[4];
		int i = 0;
		cs[i++] = new LeftInputingStatus();
		cs[i++] = new LeftInputedStatus();
		cs[i++] = new RightInputedStatus();
		cs[i++] = new RightInputedStatus();
	}
	
	public static Status create(StatusType t) {
		return cs[t.ordinal()];
	}
}
