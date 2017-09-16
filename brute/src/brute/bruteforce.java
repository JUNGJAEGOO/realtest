package brute;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class bruteforce extends JFrame {

char words[] = {'a','A','b','B','c','C','d','D','e','E','f','F','g','G','h','H','i','I','j','J','k','K','l','L',
		'm','M','n','N','o','O','p','P','q','Q','s','S','w','W','r','R','t','T','u','U','x','X','y','Y','z','Z'
		,'1','2','3','4','5','6','7','8','9','0'};
String ans = "a2\0"; 
char save[] = new char[ans.length()];
String print;

	JButton jb = new JButton("해독 시작");
	JTextArea jt = new JTextArea(15,30);
	JTextField want = new JTextField();
	JPanel one = new JPanel();
	JPanel two = new JPanel();
	bruteforce(){
		
		setLayout(new BorderLayout());
		setTitle("무차별 암호 해독기");
		setVisible(true);
		setSize(400,400);
		one.setLayout(new FlowLayout());
		add(one,BorderLayout.NORTH);
		add(two,BorderLayout.CENTER);
		//want.setSize(220,40);
		//want.setLocation(30,20);
		
		//jb.setSize(100,50);
		//jb.setLocation(260,10);
		//jt.setLocation(20,80);
		//jt.setEditable(false);
		//jt.setBackground(Color.WHITE);
		one.add(jb);
		//add(jt);
		//add(want);
		
		two.setLayout(new FlowLayout());
		myAction a = new myAction();
		jb.addActionListener(a);
		JScrollPane sc = new JScrollPane(jt);
		//sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		two.add(sc);
	}
	
	
	class myAction implements ActionListener {
		

		public void actionPerformed(ActionEvent e) {
			


    long start = System.currentTimeMillis();
	breaking :		
	for(int i=0;i<words.length;i++){
				for(int j=0;j<words.length;j++){

							save[0] = words[i];
							save[1] = words[j];
						
							print = String.valueOf(save);
							jt.append(print);
							jt.append("\n");
							if(ans.equals(print)){
								jt.append("찾았습니다! \n");
								break breaking;
							
						
					}
				}

			}
			long end = System.currentTimeMillis();
			String time1,time2;
			time1 =String.valueOf(start);
			time2 =String.valueOf(end);
			time1.substring(0, endIndex)
			jt.append(time1+"\n");
			jt.append(time2);
		}
	}

	
	
	public static void main(String args[]){
		
		new bruteforce();
	}




}
