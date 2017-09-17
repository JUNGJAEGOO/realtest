package swingprac;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

public class prr extends JFrame {
	JTextField input1 = new JTextField();
	JTextField input2 = new JTextField();
	JLabel output = new JLabel("결과");
	JLabel yz = new JLabel("연산자");
	JButton b1 = new JButton("더하기");
	JButton b2 = new JButton("빼기");
	JButton b3 = new JButton("곱하기");
	JButton b4 = new JButton("나누기");
	

prr(){
	setTitle("Open Challenge 9");
	setLayout(new BorderLayout());
	setSize(400,200);
	setVisible(true);
	NorthPanel ss = new NorthPanel();
	CenterPanel sss = new CenterPanel();
	myaction lis = new myaction();
	b1.addActionListener(lis);
	b2.addActionListener(lis);
	b3.addActionListener(lis);
	b4.addActionListener(lis);
	
	
	add(ss,BorderLayout.NORTH);
	add(sss,BorderLayout.CENTER);

	
	
}

class NorthPanel extends JPanel{
	public NorthPanel(){
	setLayout(new FlowLayout());
	setBackground(Color.lightGray);

	add(b1);
	add(b2);
	add(b3);
	add(b4);
	setVisible(true);
	}
}

class CenterPanel extends JPanel{
	public CenterPanel(){
		setLayout(null);
        yz.setLocation(80,20);
        yz.setSize(50,20);
		input1.setLocation(20, 20);
		input2.setLocation(150, 20);
		output.setLocation(250, 20);
		input1.setSize(50, 20);
		input2.setSize(50, 20);
		output.setSize(50, 20);
		add(input1);
		add(yz);
		add(input2);
		add(output);
		setVisible(true);
	}
}

class myaction implements ActionListener{
	public void actionPerformed(ActionEvent e){
		String in1;
		String in2;
		in1 = input1.getText();
		in2 = input2.getText();
		
		int a;
		int b;
		double result = 0;
		a = Integer.parseInt(in1);
		b = Integer.parseInt(in2);
		
		if(((JButton)e.getSource()).getText().equals("더하기")){
			result = a + b;
			yz.setText("+");
		}
		else if(((JButton)e.getSource()).getText().equals("빼기")){
			result = a - b;
			yz.setText("-");
		}
		else if(((JButton)e.getSource()).getText().equals("곱하기")){
			result = a * b;
			yz.setText("*");
		}
		else if(((JButton)e.getSource()).getText().equals("나누기")){
			result = (double)a / (double)b;
			yz.setText("/");
		}
		
		String result2 = Double.toString(result);
		
		output.setText(result2);
	}
}

public static void main(String args[]){
	new prr();
	
}

	
}
