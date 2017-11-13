package back1620;
import java.util.*;
import java.io.*;
public class Main {
	public static void main (String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String MandN = br.readLine();
		StringTokenizer st;
		st = new StringTokenizer(MandN," ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		HashMap<String,Integer > hash = new HashMap<>();
		String list[] = new String[100001];
		for ( int i = 1 ; i <= M ; i++){
			String input = br.readLine();
			hash.put(input,i);
			list[i] = input;
		}
		
		while ( N>0){
			String tmp = br.readLine();
			
			
			if ( isnum(tmp)){
				int StoTMP = Integer.parseInt(tmp);
				System.out.println(list[StoTMP]);
			}else{
				System.out.println(hash.get(tmp));

			}
			N--;
		}
	}
	
	public static boolean isnum(String tmp){
		try {
			Integer.parseInt(tmp);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}



}
