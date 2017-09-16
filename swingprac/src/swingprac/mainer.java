package swingprac;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;


public class mainer extends JFrame {
	JPanel contentP = new JPanel();
	JLabel la;
	JLabel la1;
	JLabel la2;
	JLabel la3;
	int a=0;
	int b=0;
	int c=0;
	mainer(){
		
		setTitle("연습용");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		//setLayout(null);

		la = new JLabel(""+a);
		la1 = new JLabel(""+b); 
		la2 = new JLabel(""+c);
		la3 = new JLabel("엔터키로 도박하세요.");
		la.setSize(70,50);
		la1.setSize(70,50);
		la2.setSize(70,50);
		la3.setSize(180,100);
		la.setLocation(80,100);
		la1.setLocation(180,100);
		la2.setLocation(280,100);
		la3.setLocation(200,150);
		

		myAction ls = new myAction();
		addKeyListener(ls);
		add(la);
		add(la1);
		add(la2);
		add(la3);
		contentP.requestFocus();
		
		setSize(500,300);
		setVisible(true);
	}
	
	class myAction extends KeyAdapter{
		public void keyTyped(KeyEvent e){
			char s = e.getKeyChar();
			if (s == '\n'){
				a= (int)(Math.random()*3);
				b= (int)(Math.random()*3);
				c= (int)(Math.random()*3);
				la.setText("" + a);
				la1.setText("" + b);
				la2.setText("" + c);
				
				if( a==b && b==c){
					la3.setText("축하합니다.");
				}
				else{
					la3.setText("아쉽습니다.");
				}
				
			}
			else if( s == '1'){
				contentP.setBackground(Color.BLUE);
			}
				
		}
		
	}
	
	
	public static void main(String args[]){
		
		new mainer();
		
	}

}



	

