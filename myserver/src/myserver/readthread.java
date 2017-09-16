package myserver;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class readthread extends Thread {

	Socket sock;
	PrintWriter pw;
	BufferedReader br;
	static ArrayList<PrintWriter> list = new ArrayList<>();
	
	public void run() {
		
		try {
			
			
			InputStream is = sock.getInputStream();
			OutputStream os = sock.getOutputStream();
			br = new BufferedReader(new InputStreamReader(is));
		    pw = new PrintWriter(new OutputStreamWriter(os));
		    String s;
		    //System.out.println("섹스");
		    String nick = br.readLine();
		    if(nick==null){
		    	System.out.println("널");
		    }
		    //System.out.println("씨발" + nick);
		    sendAll(nick+"님이 접속했습니다.");

			
		    while(true) {
			
			s=br.readLine();
			sendAll(nick+"님의 메시지: " + s);
			if (s==null) {break;}
			else if( s.equals("quit")){break;}
			
			
			}		
		    }catch(Exception e) {
			e.getStackTrace();
		}
		
	}

	public void getsock(Socket soc) {
		
		sock = soc;
		
		try {
			pw = new PrintWriter(sock.getOutputStream());
			list.add(pw);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void sendAll(String msg){
		for(PrintWriter pw : list){
			pw.println(msg);
			pw.flush();
		}
	}
}
