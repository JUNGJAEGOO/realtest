package back2845;

import java.util.StringTokenizer;
import java.io.*;
public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1 = br.readLine();
		StringTokenizer st;
		st = new StringTokenizer(input1," ");
		
		int L = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int sum = L * P;
		String input2 = br.readLine();
		st = new StringTokenizer(input2," ");
		int arr[] = new int[5];
		for ( int i = 0 ; i < 5 ; i++){
			arr[i] = Integer.parseInt(st.nextToken());
			arr[i] -= sum;
		}
		for ( int i = 0 ; i < 5 ; i++){
			System.out.print(arr[i]+" ");
		}
		
	}
}
