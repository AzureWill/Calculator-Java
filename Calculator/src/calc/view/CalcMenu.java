package calc.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class CalcMenu extends JMenuBar{
	public CalcMenu(){
		createFile();
		createHelps();
	}

	private void createFile() {
		JMenu mnFiles = new JMenu("ÎÄ¼þ(F)");
		mnFiles.setMnemonic('f');
		this.add(mnFiles);
	}

	private void createHelps() {
		JMenu mnHelps = new JMenu("°ïÖú(H)");
		mnHelps.setMnemonic('h');
		this.add(mnHelps);
	}
}
