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
	JButton act = new JButton("���� ����");
	JButton act2 = new JButton("����");
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
				chang.append("���� ������\n");
				sock = serversock.accept();
				chang.append("Ŭ���̾�Ʈ ���� �Ϸ�\n");
				
				sender = new Sender(sock);
				chang.append("���� ����\n");

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
				chang.append("�ƹ� ���ڸ� �Է����ּ���.\n");

			}
			else {	

			msg.setText("");
			try {
				if(connect == true){
				chang.append("����� ������ �� :"+s+"\n");
				sender.sendto(s);}
				else{
					chang.append("������� �Ͻʽÿ�\n");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			}
			
			
		}
	}
	
	javaserver(){
		
		setTitle("ä�� ���α׷�");
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
