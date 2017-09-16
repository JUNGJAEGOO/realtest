package myclient;
import java.util.*;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;


public class javaclient extends JFrame {
	
	static Socket sock;
	static final int port = 7779;
	static BufferedReader br;
	//static PrintWriter pw;
	Sender sender;

	JButton act = new JButton("시작");
	JButton act2 = new JButton("전송");
	JTextField name = new JTextField("닉네임입력");
	JTextField msg = new JTextField(10);
	static JTextArea chang = new JTextArea(12,20);
	JPanel one = new JPanel();
	JPanel two = new JPanel();
	JScrollPane scroll;
	boolean connect = false;
	int count = 0;
	
	class myaction implements ActionListener {
		public void actionPerformed(ActionEvent e2) {
			
			try {
				
				sock = new Socket("127.0.0.1",port);
				sender = new Sender(sock);
				InputStreamReader ir = new InputStreamReader(sock.getInputStream());
				br = new BufferedReader(ir);
				//OutputStreamWriter or = new OutputStreamWriter(sock.getOutputStream());
				//pw = new PrintWriter(or);
				//init();
				
				
				readthread rd = new readthread();
				rd.getsock(sock);
				rd.start();
				
				connect = true;
				chang.append("서버에 연결 되었습니다.\n");
		
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//public void init() throws Exception{
	//	String nickname = JOptionPane.showInputDialog("닉네임을 입력해주세요.");
	//	name.setText(nickname);
	//	pw.println(nickname);
	//	
	//}
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
	
	class send implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			String s=msg.getText();
			
			if(msg==null || s.length() == 0) {
				chang.append("아무 문자를 입력해주세요.\n");

			}
			else {	

			msg.setText("");
			try {
				if(connect == true){
				//chang.append("<당신이 보내는 말 : "+s+">\n");
				sender.sendto(s);
				count++;
				msg.requestFocus();
				if(count == 1){
					name.setText(s);
				}
				}
				else{
					chang.append("연결부터 하십시오\n");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			}
			
			
			}
	}
	
	
	javaclient() throws Exception{
		
	
		setTitle("클라이언트 채팅 프로그램");
		setLayout(new FlowLayout());
		setSize(350,300);
		scroll = new JScrollPane(chang);
		one.setLayout(new BorderLayout(0,10));
		two.setLayout(new BorderLayout());
		act.setBounds(20, 20, 50, 50);

		add(one,BorderLayout.WEST);
		add(two,BorderLayout.EAST);
		two.add(scroll,BorderLayout.NORTH );
		two.add(msg,BorderLayout.SOUTH);
		one.add(act,BorderLayout.NORTH);
		one.add(act2, BorderLayout.CENTER);
		one.add(name, BorderLayout.SOUTH);
		name.setEditable(false);
		chang.setBackground(Color.WHITE);
		chang.setEditable(false);
		myaction a = new myaction();
		send b = new send();
		act.addActionListener(a);
		act2.addActionListener(b);
		setVisible(true);
		}
	
	public static void main(String args[]) throws Exception {

		new javaclient();
		
		
	}



}

