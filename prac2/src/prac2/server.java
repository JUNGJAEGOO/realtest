package prac2;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class server {

	private BufferedReader reader;
	private ServerSocket server = null;
	private Socket socket;
	
	public void start(){
		try{
			server = new ServerSocket(12345);
			System.out.println("서버가 켜졌습니다.");
			while(true)
			{
				socket = server.accept();
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				getMessage();
				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(reader!=null) reader.close();
				if(socket!=null) socket.close();
				
			}catch(IOException e){
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void getMessage(){
		try{
			while(true){
				System.out.println("클라이언트의 메시지 : "+reader.readLine());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
