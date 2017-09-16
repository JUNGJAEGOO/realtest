package back11055;

import java.util.*;

public class Main {

	static Scanner in = new Scanner(System.in);
	static int N = in.nextInt();
	static int A[] = new int[N+1];
	static int dp[] = new int[N+1];

	public static void main(String args[]){
		for(int i=1;i<=N;i++){
			A[i] = in.nextInt();
			dp[i] = A[i];
		}
		
		
		
		for(int i=1;i<=N;i++){
			for(int j=1;j<=i;j++){
				if( A[j] < A[i]){
					dp[i] = Math.max(dp[i],dp[j]+A[i]);

				}
				
			}
			
		}
		
		int max = -1;
		for(int i=1;i<=N;i++){
			if(max<dp[i]){
				max = dp[i];
			}
			System.out.println(dp[i]);
		}


		

		
		System.out.println(max);
		
	}
	
}
