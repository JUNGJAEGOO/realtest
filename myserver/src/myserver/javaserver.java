package myserver;

import java.util.*;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;


public class javaserver extends JFrame {
	
	static ServerSocket serversock = null;
	static Socket sock;
	static final int port = 7008;
	static BufferedWriter bw = null;
	Sender sender;
	JButton act = new JButton("서버 가동");
	JButton act2 = new JButton("전송");
	JTextField msg = new JTextField(10);
	static JTextArea chang = new JTextArea(12,20);
	JPanel one = new JPanel();
	JPanel two = new JPanel();
	JScrollPane scroll;
	boolean connect = false;
	
	class myaction implements ActionListener {
		public void actionPerformed(ActionEvent e2) {
			
			try {
				
				serversock = new ServerSocket(port);
				chang.append("서버 구동중\n");
				sock = serversock.accept();
				chang.append("클라이언트 연결 완료\n");
				
				sender = new Sender(sock);
				chang.append("센더 생성\n");

				readthread rd = new readthread();

				rd.getsock(sock);
				rd.start();
				
				connect = true;
		
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	class Sender {
		PrintWriter writer;
		Sender(Socket s_sock){
			
			try {
				writer = new PrintWriter(s_sock.getOutputStream());
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		public void sendto(String message) {
			if (writer != null) {
				try {
					writer.println(message);
					writer.flush();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	class my2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			String s=msg.getText();
			
			if(msg==null || s.length() == 0) {
				chang.append("아무 문자를 입력해주세요.\n");

			}
			else {	

			msg.setText("");
			try {
				if(connect == true){
				chang.append("당신이 보내는 말 :"+s+"\n");
				sender.sendto(s);}
				else{
					chang.append("연결부터 하십시오\n");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			}
			
			
		}
	}
	
	javaserver(){
		
		setTitle("채팅 프로그램");
		setLayout(new FlowLayout());
		setSize(350,300);
		scroll = new JScrollPane(chang);
		one.setLayout(new BorderLayout());
		two.setLayout(new BorderLayout());
		act.setBounds(20, 20, 50, 50);

		add(one,BorderLayout.WEST);
		add(two,BorderLayout.EAST);
		two.add(scroll,BorderLayout.NORTH );
		two.add(msg,BorderLayout.SOUTH);
		one.add(act,BorderLayout.CENTER);
		one.add(act2, BorderLayout.SOUTH);
		chang.setBackground(Color.WHITE);
		chang.setEditable(false);
		myaction a = new myaction();
		my2 b = new my2();
		act.addActionListener(a);
		
		act2.addActionListener(b);
		requestFocus();
		setVisible(true);
		
		
		
		
	}
	
	public static void main(String args[]) {

		new javaserver();
		
		
	}



}
