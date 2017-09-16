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
			System.out.println("서버 생성중....");
			
			while(true){
				
			sock = multisock.accept();
			
			readthread rt = new readthread();
			rt.getsock(sock);
			rt.start();
			System.out.println("new 클라이언트 입장, 주소는  "+sock.getInetAddress());

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
