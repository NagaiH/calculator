package calculator;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CalGUI extends JFrame {

 JPanel contentPane = new JPanel();
 BorderLayout borderLayout1 = new BorderLayout();
 JTextField result = new JTextField(""); //計算結果を表示するテキストフィールド

 //フレームのビルド
 public CalGUI() {
  contentPane.setLayout(borderLayout1);
  this.setSize(new Dimension(250, 300));
  this.setTitle("でんたくぅ");
  this.setContentPane(contentPane);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  contentPane.add(result, BorderLayout.NORTH); //テキストフィールドを配置

  JPanel keyPanel = new JPanel(); //ボタンを配置するパネルを用意
  keyPanel.setLayout(new GridLayout(4, 4)); //4行4列のGridLayoutにする
  contentPane.add(keyPanel, BorderLayout.CENTER);

  keyPanel.add(new NumberButton("7"), 0); //ボタンをレイアウトにはめこんでいく
  keyPanel.add(new NumberButton("8"), 1);
  keyPanel.add(new NumberButton("9"), 2);
  keyPanel.add(new CalcButton("+"), 3);
  keyPanel.add(new NumberButton("4"), 4);
  keyPanel.add(new NumberButton("5"), 5);
  keyPanel.add(new NumberButton("6"), 6);
  keyPanel.add(new CalcButton("*"), 7);
  keyPanel.add(new NumberButton("1"), 8);
  keyPanel.add(new NumberButton("2"), 9);
  keyPanel.add(new NumberButton("3"), 10);
  keyPanel.add(new CalcButton("-"), 11);
  keyPanel.add(new NumberButton("0"), 12);
  keyPanel.add(new JButton("."), 13);
  keyPanel.add(new CalcButton("/"), 14);
  keyPanel.add(new AnsButton("＝"), 15);

  contentPane.add(new CleanButton("C"), BorderLayout.SOUTH);//Cボタンを配置する
  this.setVisible(true);
 }
	private void appendResult(String str) {
		result.setText(result.getText() + str);
		
	}
	private void appendcalcResult(String str) {
		result.setText(result.getText()+ " " + str+ " ");
		
	}
	private void cleanResult(){
		result.setText("");
	}

 	public class NumberButton extends JButton implements ActionListener{
 		public NumberButton(String num){
 			super(num);
 			this.addActionListener(this);
 		}

 		@Override
 		public void actionPerformed(ActionEvent e) {
 			String num = this.getText();
 			appendResult(num);	
 		}	 
 	}
 	public class CalcButton extends JButton implements ActionListener{
 		public CalcButton(String ope){
 			super(ope);
 			this.addActionListener(this);
 		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String ope = this.getText();
			appendcalcResult(ope);
			
		}
 		
 	}
 	public class AnsButton extends JButton implements ActionListener{
 		public AnsButton(String ope){
 			super(ope);
 			this.addActionListener(this);
 		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Calculate cal = new Calculate(result.getText());
			String ans = Integer.toString(cal.GetAns());
			cleanResult();
			appendResult(ans);
			
		}
 		
 	}
 	public class CleanButton extends JButton implements ActionListener{
 		public CleanButton(String c){
 			super(c);
 			this.addActionListener(this);
 		}
 		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			cleanResult();
			
		}
 		
 	}


}