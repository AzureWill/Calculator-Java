import java.awt.Insets;

import calc.view.FrameMain;


public class Entry {
	public static void main(String[] args) {
		FrameMain sc = new FrameMain();
		sc.setVisible(true);
		Insets s = sc.getInsets();
		sc.setSize(236+s.left * 2, 24 + 236 + s.top + s.bottom);
		sc.setLocationRelativeTo(null);
	}
}
