package myserver;

import java.net.*;
import java.util.*;
import java.io.*;


public class multiserver {

	static final int port = 7779;
	static Socket sock;
	static ServerSocket multisock = null;
	
	
	public static void main(String args[]){
		
		try {
			multisock = new ServerSocket(port);
			System.out.println("���� ������....");
			
			while(true){
				
			sock = multisock.accept();
			
			readthread rt = new readthread();
			rt.getsock(sock);
			rt.start();
			System.out.println("new Ŭ���̾�Ʈ ����, �ּҴ�  "+sock.getInetAddress());

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
