package calc.view;

import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import calc.model.CalcServer;
import calc.model.Operator;
import calc.model.ResultListener;

public class FrameMain extends JFrame{
	private  JTextField txtResult;
	private CalcServer server = new CalcServer();
	public FrameMain(){
		initializeComponents();
		server.addResultListener(new ResultListener() {
			
			@Override
			public void show(String text) {
				text = text.replaceFirst("^0{2,}", "0");//去重点的正则表达式
				text = text.replaceFirst("^0(?=[1-9])", "");//去重0的正则表达式
//				text = text.replaceAll("(?<=\\d)(?=(\\d{3})+$)", ",");  //加千分位的正则表达式
				txtResult.setText(text);
				
			}
		});
		
	}
	
	private class ClearHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			server.pressedClear();
		}
		
	}
	
	private class NumberHandler implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e){
		JButton btn = (JButton)e.getSource();
		server.pressedNumber(btn.getText());
	}}
	
	private class OperatorHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			server.pressedOperator(btn.getName());
			
		}
		
	}
	
	private class EqualsHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			server.pressedEqual();
		}
		
	}

	private void initializeComponents() {

	    txtResult = new JTextField("0");
	    txtResult.setFont(new Font(txtResult.getFont().getName(),Font.BOLD,24));
		txtResult.setFont(new Font("time new roman",Font.BOLD, 20));
		txtResult.setBounds(12, 8, 212, 40);
		txtResult.setFocusable(false);
		txtResult.setHorizontalAlignment(JTextField.RIGHT);
		
		JLabel lbMemory = new JLabel();
		lbMemory.setBounds(12, 56, 36, 28);
		lbMemory.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		
		JButton btnCE = new JButton("CE");
		btnCE.setBounds(56,56,36,28);
		btnCE.setMargin(new Insets(0, 0, 0, 0));
		btnCE.setFocusable(false);
		

		JButton btnClear = new JButton("C");
		btnClear.setBounds(100,56,36,28);
		btnClear.setMargin(new Insets(0, 0, 0, 0));
		btnClear.addActionListener(new ClearHandler());
		btnClear.setFocusable(false);
		
		JButton btnBackspace = new JButton("Backspace");
		btnBackspace.setBounds(144,56,80,28);
		btnBackspace.setMargin(new Insets(0, 0, 0, 0));
		btnBackspace.setFocusable(false);
		
		String[] a = {"MC","7","8","9","-","MR","4","5","6","*","MS","1","2","3","/","M+","0",".","+","="};
		
		String[] names  = {"MC","7","8","9","SUB","MR","4","5","6","MUL","MS","1","2","3","DIV","M+","0",".","ADD","="};
		
		NumberHandler nh = new NumberHandler();
		OperatorHandler oh = new OperatorHandler();
		EqualsHandler eh = new EqualsHandler();
		
		
		ActionListener[] handlers = {null,nh,nh,nh,oh,null,nh,nh,nh,oh,null,nh,nh,nh,oh,null,nh,nh,oh,eh,};
		
		for (int i = 0; i < a.length; i++) {
			JButton btn  = new JButton(a[i]);
			btn.setName(names[i]);
			int x = 12 + (i % 5) * 44;
			int y = 92 +(i / 5) * 36; 
			btn.setBounds(x, y, 36, 28);
			btn.setMargin(new Insets(0, 0, 0, 0));
			btn.addActionListener(handlers[i]);
			btn.setFocusable(false);
			this.add(btn);
		}
		
		this.setLayout(null);
		this.add(lbMemory);
		this.add(txtResult);
		this.add(btnClear);
		this.add(btnCE);
		this.add(btnBackspace);
		this.setJMenuBar(new CalcMenu());
		this.setTitle("计算器");
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	

	
}
