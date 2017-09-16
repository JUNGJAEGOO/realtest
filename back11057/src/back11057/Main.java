package back11057;

import java.util.*;

public class Main {

	static Scanner in = new Scanner(System.in);
	static int N = in.nextInt();
	static int DP[] = new int[N+1];
	public static void main(String args[]){
		
		DP[1] = 10;
		DP[2] = DP[1] + 45;
		for( int i = 3 ; i<= N ; i++){
		
			int diff = DP[i-1] - DP[i-2];
			int sum = 0;
			
			for ( int s = 9 ; s > 0 ; s--){
				
			for ( int j = 9 ; j > 9-s ; j--){
				sum = sum - j;
			}
			}
			//System.out.println(diff);
			//System.out.println(sum);
			
			DP[i] =  (DP[i-1] + 10*diff + sum) % 10007;
			
		
		
				
		}
		
		//for( int i = 1 ; i <= N ; i++ ){
		System.out.println(DP[N]);
		//}
	}
}
