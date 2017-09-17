package hang;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;

public class asd extends JFrame {
	
	static String answer = null;
	static char[] answer1 = null;
	static String answer2 = null;

	JLabel txt;
	JLabel result;
	JTextField box1 = new JTextField();
	JTextField box2 = new JTextField();
	JButton bu = new JButton("확인");
	
	asd(){
		setTitle("행맨 게임");
		setLayout(null);
		
		
		txt = new JLabel(answer2);
		result = new JLabel("정답판별");
		txt.setSize(60, 30);
		box1.setSize(80,30);
		box2.setSize(80,30);
		bu.setSize(60,30);
		result.setSize(100,30);
		
		txt.setLocation(20, 50);
		result.setLocation(400, 50);
		box1.setLocation(100, 50);
		box2.setLocation(200, 50);
		bu.setLocation(300, 50);
		
		//mykeyAction ac1 = new mykeyAction();
		myAction ac2 = new myAction(answer);
		bu.addActionListener(ac2);
		
		add(box1);
		add(box2);
		add(txt);
		add(bu);
		add(result);
		
		setSize(500,170);
		setBackground(Color.cyan);
		setVisible(true);
		requestFocus();
		
	}
	
	class mykeyAction extends KeyAdapter{
		public void keyTyped(KeyEvent e){
			
			//if()
		
		}
		
	}
	
	//오버라이딩
	class myAction implements ActionListener{
		String realAns;
		
		public myAction(String s){
			this.realAns = s;
		};
		
		public void actionPerformed(ActionEvent e) {
			String imsi1;
			String imsi2;
			
			char[] answering = txt.getText().toCharArray(); 
			
			imsi1 = String.valueOf(realAns.charAt(1));
			imsi2 = String.valueOf(realAns.charAt(3));
			
			String bigyo1;
			String bigyo2;
			bigyo1 = box1.getText();
			bigyo2 = box2.getText();


			  if(bigyo1.equals(imsi1) && bigyo2.equals(imsi2)){
					  answering[1] = bigyo1.charAt(0);
					  answering[3] = bigyo2.charAt(0);
					  txt.setText(String.valueOf(answering));
					  result.setText("모두 정답");
				}	
			  else if(bigyo1.equals(imsi1)){
				  answering[1] = bigyo1.charAt(0);
				  txt.setText(String.valueOf(answering));
				  result.setText("왼쪽만 정답");
			  }
			  else if(bigyo2.equals(imsi2)){
				  answering[3] = bigyo2.charAt(0);
			      txt.setText(String.valueOf(answering));
			      result.setText("오른쪽만 정답");
			  }
			
		}
	}
	
	
	
	public static void main(String args[]){
		BufferedReader br = null;
		BufferedReader br1 = null;
		try {
			br = new BufferedReader(new FileReader("c:\\tmp2\\word.txt"));
			br1 = new BufferedReader(new FileReader("c:\\tmp2\\word.txt"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String s = null;
		String b = null;
		
		int i = 0;
		try {
			while( (s=br.readLine()) != null ){
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int sum = i;
		int rand = (int)(Math.random()*i);
		System.out.println("총 줄의 수 : "+sum);
		String[] game = new String[sum];
		i = 0;
		
		try {
			while( (b=br1.readLine()) != null ){
				
				game[i] = b;
				System.out.println(game[i]);
				i++;
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("선택된 단어 " + game[rand]);
		
		answer = game[rand];
		char[] answer1 = new char[sum];
		answer1 = game[rand].toCharArray();
		answer1[1] = '_';
		answer1[3] = '_';
		answer2 = String.valueOf(answer1);
		
		System.out.println("변형된 단어 ");
		for(int j=0;j<answer.length();j++){
			System.out.print(answer1[j]);
		}
		System.out.println("");
		
		new asd();
		
		
	}
	
}
