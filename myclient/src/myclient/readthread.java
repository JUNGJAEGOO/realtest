package myclient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class readthread extends Thread {

	Socket sock;
	
	
	public void run() {
		
		try {
			
			javaclient.chang.append("Ŭ���̾�Ʈ ��� ������ ���� \n");
			//InputStream is = sock.getInputStream();
			//BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String s;
			
			
		while(true) {
			
			    s = javaclient.br.readLine();
			    if ( s==null){ break;}
				//System.out.println(s);
				javaclient.chang.append(s+"\n");
			
			
			
		}
		
		
		
		}catch(Exception e) {
			e.getStackTrace();
		}
		
	}

	public void getsock(Socket soc) {
		
		sock = soc;
	}
}
